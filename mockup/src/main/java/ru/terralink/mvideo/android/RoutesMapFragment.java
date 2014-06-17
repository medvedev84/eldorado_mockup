package ru.terralink.mvideo.android;

/**
 * Fragment для показа карты с марщрутами
 * @author Медведев Константин
 */

import android.app.Dialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.IntentSender;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ru.terralink.mvideo.android.adapter.MapRoutesExpandableListAdapter;
import ru.terralink.mvideo.android.data.DataStorage;
import ru.terralink.mvideo.android.map.RoutesDrawer;
import ru.terralink.mvideo.android.model.Order;
import ru.terralink.mvideo.android.model.OrderStatus;
import ru.terralink.mvideo.android.model.Route;

public class RoutesMapFragment
        extends Fragment
        implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {


    // Задает код запроса для посылки в сервисы Google Play
    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;

    // элементы фрагмента для отображения карт
    protected MapView mapView;
    protected GoogleMap map;

    // клиент для определения текущего местоположения
    private LocationClient mLocationClient;

    private ExpandableListView expListView;
    // список из одного элемента для группировки маршрутов (такая иммитация нужна для элемента ExpandableListView, который работает только со списками)
    private List<String> routes;
    // список маршрутов
    private HashMap<String, List<Route>> routesCollection;
    // диалог для отображения прогресса выполнения фоновой операции
    private ProgressDialog progressInitMap;

    // выбранный маршрут
    private Route selectedRoute = null;
    // текущий выделенный элемент выпадающего списка
    private View highlighted;
    // список заказов, по которым строится маршрут
    private List<Order> ordersForRoute = new ArrayList<Order>();

    public RoutesMapFragment() {
        // Любой фрагмент должен иметь пустой конструктор по умолчанию
    }

    public RoutesMapFragment(Route route) {
        this.selectedRoute = route;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
        mapView = (MapView) rootView.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        // подготавливаем данные для карты
        prepareData();

        progressInitMap = new ProgressDialog(getActivity());
        progressInitMap.setMessage(getResources().getString(R.string.initializing_map));
        progressInitMap.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressInitMap.setCancelable(false);
        progressInitMap.show();

        map = mapView.getMap();

        // инициализируем клиента для определения местоположения
        mLocationClient = new LocationClient(getActivity(), this, this);

        // конфигурируем карту
        configureMap(map);

        LinearLayout routesControl = (LinearLayout) rootView.findViewById(R.id.routesControl);
        expListView = (ExpandableListView) rootView.findViewById(R.id.map_route_list);
        // обработчик нажатия на старшие элементы вложенного списка - если список свернули, то необходимо убрать графическое выделение с текущего элемента
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                clearHighlighted();
            }
        });
        // обработчик нажатия на младшие элементы вложенного списка
        expListView.setOnChildClickListener(
                new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                        // сохраняем выбранный маршрут как текущий марщрут
                        selectedRoute = DataStorage.getRoutes().get(childPosition);
                        // получаем заказы для маршрута
                        List<Order> orders = selectedRoute.getOrders();
                        // очищаем карту (удаляем предыдущие маршруты, если были)
                        map.clear();
                        // строим маршрут для заказов
                        drawRote(orders);
                        // подсвечиваем выделенный маршрут в списке
                        highlight(v);
                        return false;
                    }
                }
        );
        expListView.setAdapter(
                new MapRoutesExpandableListAdapter(
                        getActivity(),
                        routes,
                        routesCollection,
                        this
                )
        );

        // кнопка очистки карты и ее обработчик
        ImageView clearRoutesBtn = (ImageView) rootView.findViewById(R.id.clearRoutesBtn);
        clearRoutesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.clear();
                selectedRoute = null;
                clearHighlighted();
            }
        });

        // показываем список маршрутов и кнопку очистки экрана поверх карты
        routesControl.bringToFront();
        return rootView;
    }

    /**
     * Метод для снятия выделение (если таковое имелось)
     * Делает фон белым, а текст на нем - черным
     */
    private void clearHighlighted(){
        if (highlighted != null) {
            highlighted.setBackgroundColor(Color.WHITE);
            TextView routeLabel = (TextView) highlighted.findViewById(R.id.route_number);
            routeLabel.setTextColor(Color.BLACK);
        }
        highlighted = null;
    }

    /**
     * Метод для подсветки выделенного элемента вложенного списка
     * Делает фон красным, а текст на нем - белым
     * @param v элемента списка для подсветки
     */
    private void selectHighlighted(View v){
        v.setBackgroundColor(Color.RED);
        TextView routeLabel = (TextView) v.findViewById(R.id.route_number);
        routeLabel.setTextColor(Color.WHITE);
        highlighted = v;
    }

    /**
     * Метод для подсветки выделенного элемента вложенного списка.
     * Сначала снимает выделение (если таковое имелось), затем графически выделяет заданный элемент
     * @param v элемента списка для подсветки
     */
    public void highlight(View v){
        clearHighlighted();
        selectHighlighted(v);
    }

    /**
     * Метод построения маршрута для заказов
     * @param orders список заказов
     */
    private void drawRote(List<Order> orders){
        // инициализация списка строковых адресов
        List<String> addresses = new ArrayList<String>();
        // очистка списка заказов для построения маршрута
        ordersForRoute.clear();

        for (Order order: orders) {
            // маршрут строится только для заказов со статусом "погрузка завершена" или "задержка"
            if (order.getStatus() == OrderStatus.LOAD_END || order.getStatus() == OrderStatus.Z_DELAY) {
                addresses.add(order.getAddressForSearch());
                ordersForRoute.add(order);
            }
        }

        // если список адресов пуст, то показываем соответствующее сообщение и заканчиваем работу метода
        if (addresses.size() == 0){
            Toast.makeText(getActivity(), R.string.no_routes_to_draw, Toast.LENGTH_SHORT).show();
            return;
        }

        // получаем текущее местоположение
        Location location = mLocationClient.getLastLocation();
        LatLng initPoint = new LatLng(location.getLatitude(), location.getLongitude());

        // инициализируем класс-помощник для отрисовки
        RoutesDrawer drawer = new RoutesDrawer(getActivity(), map, initPoint, addresses);
        // отрисовываем маршрут
        drawer.draw();
    }

    /**
     * Метод для подготовки данных для экрана
     */
    private void prepareData() {
        routes = new ArrayList<String>();
        routesCollection = new HashMap<String, List<Route>>();
        routes.add(getResources().getString(R.string.routes));
        // выбранная коллекция содержит один элемент - строку "маршруты" как ключ и список маршрутов как значение
        routesCollection.put(routes.get(0), DataStorage.getRoutes());
    }

    /**
     * Метод конфигурации карты
     */
    private void configureMap(GoogleMap map)
    {
        if (map == null)
            return; // если сервис Google Maps не доступен, то заверщаем работу
        try {
            MapsInitializer.initialize(getActivity()); // инициализируем карту
        }
        catch (GooglePlayServicesNotAvailableException e) {
            return;
        }

        // задаем кнопку "мое местоположение"
        map.setMyLocationEnabled(true);
        // задаем слой "пробки"
        map.setTrafficEnabled(true);
        // задаем обработчик нажатия на всплывающие подсказки у маркеров
        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                try {
                    // получаем идентификатор маркера (по android задает значения вида m1, m2, ...)
                    int orderId = Integer.valueOf(marker.getId().substring(1));
                    // показываем карточку заказа с заданным идентификатором
                    ((MainDrawerActivity) getActivity()).showAddressCard(ordersForRoute.get(orderId));
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Couldn't ger marker id", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Метод перемещения центра карты и изменения масштаба
     * @param point новый центр карты
     * @param zoomValue новый масштаб карты
     */
    private void moveAndZoomCamera(LatLng point, int zoomValue){
        CameraUpdate camera = CameraUpdateFactory.newLatLng(point);
        map.moveCamera(camera);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(zoomValue);
        map.animateCamera(zoom);
    }

    @Override
    public void onStart() {
        super.onStart();
        // подключение к сервису локации при старте экрана
        mLocationClient.connect();
    }

    @Override
    public void onStop() {
        // отключение от сервиса локации при остановке экрана
        mLocationClient.disconnect();
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    /**
     * Обработчик подключения к сервису локации
     */
    @Override
    public void onConnected(Bundle bundle) {
        // получаем последнюю обновленную локацию
        Location location = mLocationClient.getLastLocation();
        LatLng initPoint = new LatLng(location.getLatitude(), location.getLongitude());
        // переводим центр карты в точку последней локации
        moveAndZoomCamera(initPoint, 7);
        // убираем диалог прогресса выполнения операции
        progressInitMap.dismiss();

        // если список марщрутов не пуст, то отрисовываем маршрут для текущего выбранного маршрута
        if (routesCollection.get(routes.get(0)).size() > 0){
            expListView.expandGroup(0);
            List<Order> orders = selectedRoute.getOrders();
            drawRote(orders);
        } else {
            Toast.makeText(getActivity(), R.string.no_routes_to_draw, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Обработчик отключения от сервису локации
     */
    @Override
    public void onDisconnected() {
        Toast.makeText(getActivity(), R.string.google_service_disconnected, Toast.LENGTH_SHORT).show();
    }

    /**
     * Обработчик ошибки подключения к сервису локации
     */
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (progressInitMap != null)
            progressInitMap.dismiss();
        /*
         * сервисы Google Play могут самостоятельно решить некоторые ошибки
         * Если ошибка имеет решение, то надо попытаться запустить встроенное activity сервисов Google Play services
         */
        if (connectionResult.hasResolution()) {
            try {
                connectionResult.startResolutionForResult(getActivity(), CONNECTION_FAILURE_RESOLUTION_REQUEST);
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }
        } else {
            /*
             * Если ошибка не может быть решена, то надо показать сообщение
             */
            int errorCode = connectionResult.getErrorCode();

            // получаем диалог ошибки серисов Google Play
            Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(errorCode, getActivity(), CONNECTION_FAILURE_RESOLUTION_REQUEST);

            // если сервисы Google Play предоставляют такой диалог, то показываем его
            if (errorDialog != null) {
                errorDialog.show();
            }
        }
    }

    // метод доступа к выделенному маршруту
    public Route getSelectedRoute() {
        return selectedRoute;
    }
}