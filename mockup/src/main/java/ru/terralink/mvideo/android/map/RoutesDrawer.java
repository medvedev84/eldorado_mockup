package ru.terralink.mvideo.android.map;

/**
 * Класс-помощник для отрисовки маршрута на карте
 * @author Медведев Константин
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.terralink.mvideo.android.R;

public class RoutesDrawer implements RoutingListener {

    // имя тэга в выходном потоке логгера
    private static final String TAG = "RoutesDrawer";
    // экземпляр карты
    private GoogleMap map;
    // массив адресов-строк
    private List<String> strAddresses;
    // массив объектов Address
    private List<Address> addresses;
    // начальная точка построения маршрута
    private LatLng point0;
    private Context context;

    public RoutesDrawer(Context context, GoogleMap map, LatLng initPoint, List<String> strAddresses){
        this.context = context;
        this.map = map;
        this.strAddresses = strAddresses;
        this.point0 = initPoint;
    }

    /**
     *  Публичный метод для отрисовки. Получает массив объектов Address по массиву строк и далее отрисовывает маршрут
     */
    public void draw(){
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        if (resultCode != ConnectionResult.SUCCESS) {
            Toast.makeText(context, R.string.google_service_unavailable, Toast.LENGTH_SHORT).show();
            return;
        }
        addresses = getAddresses(strAddresses);
        drawRoutes(addresses);
    }

    @Override
    public void onRoutingFailure() {}

    @Override
    public void onRoutingStart() {}

    /**
     *  Listener события onRoutingSuccess. Событие возникает, если удалось построить маршрут для всех точек
     *  @param mPolyOptions параметры отрисовки маршрута
     */
    @Override
    public void onRoutingSuccess(PolylineOptions mPolyOptions) {
        Log.i(TAG, "\nRoute is built, start adding to the map...\n");
        PolylineOptions polyoptions = new PolylineOptions();
        polyoptions.color(Color.BLUE);
        polyoptions.width(5);
        polyoptions.addAll(mPolyOptions.getPoints());
        map.addPolyline(polyoptions);
        Log.i(TAG, "\nRoute added to the map.\n");
    }

    /**
     *  Приватный метод для отрисовки маршрута. Получает массив объектов Address по массиву строк и далее отрисовывает маршрут
     *  @param points массив объектов Address
     */
    private void drawRoutes(final List<Address> points){
        Log.i(TAG, "\nStart building the route...\n");
        final ProgressDialog progressRoutes = new ProgressDialog(context);
        progressRoutes.setMessage(context.getResources().getString(R.string.drawing_routes));
        progressRoutes.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressRoutes.setCancelable(false);
        progressRoutes.show();
        // строим маршрут в фоне (отдельном потоке)
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                // в цикле для всех точек массива рисуем поочерди строим маршут между двумя точками
                for (int i = 0; i < points.size(); i++) {
                    // для первой точки маршруты в качестве отправного пункта берем текущее местоположение
                    if (i == 0) {
                        Address address = addresses.get(i);
                        LatLng point1 = new LatLng(address.getLatitude(), address.getLongitude());
                        drawRoute(point0, point1);
                        continue;
                    }
                    Address address = addresses.get(i - 1);
                    LatLng point1 = new LatLng(address.getLatitude(), address.getLongitude());
                    address = addresses.get(i);
                    LatLng point2 = new LatLng(address.getLatitude(), address.getLongitude());

                    Log.i(TAG, "\nStart drawing route between two points...\n");
                    // отрисовка маршрута между двумя точками
                    drawRoute(point1, point2);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void param) {
                progressRoutes.hide();
                for (int i=0; i< addresses.size(); i++) {
                    Address address = addresses.get(i);
                    LatLng point = new LatLng(address.getLatitude(), address.getLongitude());

                    MarkerOptions options = new MarkerOptions();
                    options.position(point);
                    options.title(address.getAddressLine(0));

                    // задаем картинку для маркера в зависимости от порядкого номера точки в марщруте
                    int drawableId = R.drawable.iconr;
                    switch (i) {
                        case 0:
                            drawableId = R.drawable.iconr1;
                            break;
                        case 1:
                            drawableId = R.drawable.iconr2;
                            break;
                        case 2:
                            drawableId = R.drawable.iconr3;
                            break;
                        case 3:
                            drawableId = R.drawable.iconr4;
                            break;
                        case 4:
                            drawableId = R.drawable.iconr5;
                            break;
                        case 5:
                            drawableId = R.drawable.iconr6;
                            break;
                        case 6:
                            drawableId = R.drawable.iconr7;
                            break;
                        case 7:
                            drawableId = R.drawable.iconr8;
                            break;
                        case 8:
                            drawableId = R.drawable.iconr9;
                            break;
                        case 9:
                            drawableId = R.drawable.iconr10;
                            break;
                        case 10:
                            drawableId = R.drawable.iconr11;
                            break;
                        case 11:
                            drawableId = R.drawable.iconr12;
                            break;
                        case 12:
                            drawableId = R.drawable.iconr13;
                            break;
                        case 13:
                            drawableId = R.drawable.iconr14;
                            break;
                        case 14:
                            drawableId = R.drawable.iconr15;
                            break;
                        case 15:
                            drawableId = R.drawable.iconr16;
                            break;
                        case 16:
                            drawableId = R.drawable.iconr17;
                            break;
                        case 17:
                            drawableId = R.drawable.iconr18;
                            break;
                        case 18:
                            drawableId = R.drawable.iconr19;
                            break;
                        case 19:
                            drawableId = R.drawable.iconr20;
                            break;
                        case 20:
                            drawableId = R.drawable.iconr21;
                            break;
                        case 21:
                            drawableId = R.drawable.iconr22;
                            break;
                        case 22:
                            drawableId = R.drawable.iconr23;
                            break;
                        case 23:
                            drawableId = R.drawable.iconr24;
                            break;
                        case 24:
                            drawableId = R.drawable.iconr25;
                            break;
                    }
                    options.icon(BitmapDescriptorFactory.fromResource(drawableId));

                    map.addMarker(options);
                }

                // если массив адресов не пуст, то наводим камеру на последнюю точку в маршруте
                if (addresses.size() > 0) {
                    Address address = addresses.get(addresses.size() - 1);
                    LatLng point = new LatLng(address.getLatitude(), address.getLongitude());
                    moveAndZoomCamera(point, 10);
                }
            }
        }.execute();
    }

    /**
     *  Метод построения маршрута между двумя точками. Используем класс Routing вспомогательной библиотеки com.directions.route
     *  @param start начальная точка
     *  @param end конечная точка
     */
    private void drawRoute(LatLng start, LatLng end){
        Routing routing = new Routing(Routing.TravelMode.DRIVING);
        routing.registerListener(this);
        routing.execute(start, end);
    }

    /**
     *  Приватный метод получения объектов Address по строковым адресам
     *  @param addresses массив строк
     */
    private List<Address> getAddresses(final List<String> addresses){
        Log.i(TAG, "\nStart getting points...\n");
        final List<Address> points = new ArrayList<Address>();
        final ProgressDialog progressLatLng = new ProgressDialog(context);
        progressLatLng.setMessage(context.getResources().getString(R.string.getting_coordinates));
        progressLatLng.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressLatLng.setCancelable(false);
        progressLatLng.show();

        new AsyncTask<Void, Void,  List<Address>>() {
            @Override
            protected List<Address> doInBackground(Void... params) {
                // в цикле для каждого адреса-строки ищется ее геолокация
                for (String strAddress: addresses){
                    Address point = getAddress(strAddress);
                    if (point != null) {
                        points.add(point);
                    }
                }
                return points;
            }

            @Override
            protected void onPostExecute(final List<Address> points) {
                progressLatLng.hide();
            }
        }.execute();

        return points;
    }

    /**
     *  Метод обращается к сервису Google Geolocationи по строке адреса получает объект Address
     *  @param strAddress координаты точки
     */
    private Address getAddress(String strAddress){
        Address point = null;
        try {
            List<Address> results = new Geocoder(context).getFromLocationName(strAddress, 1);
            if (results.size() > 0) {
                Log.i(TAG, "\nCoordinates for " + strAddress + " received!\n");
                point = results.get(0);
            }
        } catch (IOException e) {
            Log.e(TAG, "\nCan not get coordinates for " + strAddress + "\n");
        }
        return point;
    }

    /**
     *  Метод переносит камеру на заданную точку и задает масштаб
     *  @param point координаты точки
     *  @param zoomValue мастштаб
     */
    private void moveAndZoomCamera(LatLng point, int zoomValue){
        CameraUpdate camera = CameraUpdateFactory.newLatLng(point);
        map.moveCamera(camera);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(zoomValue);
        map.animateCamera(zoom);
    }
}
