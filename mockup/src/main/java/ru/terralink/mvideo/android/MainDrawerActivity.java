package ru.terralink.mvideo.android;

/**
 * Главная activity приложения. Управляет переходами между пунктами меню.
 * @author Медведев Константин
 */
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Stack;

import ru.terralink.mvideo.android.async.LoadAsyncTask;
import ru.terralink.mvideo.android.data.DataConnector;
import ru.terralink.mvideo.android.data.DataStorage;
import ru.terralink.mvideo.android.model.Order;
import ru.terralink.mvideo.android.model.Route;

public class MainDrawerActivity extends ActionBarMutableActivity {

    // вспомогательные переметки для хранения данных о разметке activivty
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    // идентификаторы экранов
    private final int SHOW_ADDRESS_DETAILS = -1;
    private final int SHOW_ADDRESS_LIST = 0;
    private final int SHOW_MAP = 1;
    private final int SHOW_PROFILE = 2;
    private final int SHOW_SETTINGS = 3;
    private final int LOGOUT = 4;
    // переменная для хранения идентификатора текущего экрана
    private int selectedPosition = 0;

    // признак необходимости обновления данных
    public static boolean needToUpdate = false;
    // признак наличия несинхронизированных данных
    public static boolean uncommitedChanges = false;
    // текущий заказ
    public static Route selectedRoute = null;
    // строковый массив названий элементов меню
    private String[] mMenuTitles;
    // стэк переходов по экранам, необходим для корректной обработки кнопки "назад"
    private Stack<ScreenIterator> router = new Stack<ScreenIterator>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);

        // показ диалога с выбором  даты
        showDatePickerDialog();

        mMenuTitles = getResources().getStringArray(R.array.menu_titles_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mMenuTitles));
        mDrawerList.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });

        // позволяем иконке в action bar действовать как toggle-кнопка (показывать/скрывать менбпо нажатию)
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(false);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                invalidateOptionsMenu();
            }
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final Context context = this;
        if (uncommitedChanges && DataConnector.isOnline(context)){
            // если есть несинхронизированные данные и устройство подключено к сети интернет, то запускаем синхронизацию
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(R.string.sync_dialog_title);
            builder.setMessage(R.string.sync_dialog_body);
            builder.setPositiveButton(R.string.dialog_yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    final ProgressDialog progressRoutes = new ProgressDialog(context);
                    progressRoutes.setMessage(context.getString(R.string.loading));
                    progressRoutes.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressRoutes.setCancelable(false);
                    progressRoutes.show();

                    // преобразование даты к типа "дата", используемому в БД
                    SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
                    String strDate = sm.format(DataStorage.getSelectedDate());
                    java.sql.Date syncDate = java.sql.Date.valueOf(strDate);

                    // синхронизация делается в отдельном потоке
                    LoadAsyncTask loadTask = new LoadAsyncTask(
                            context, DataStorage.getVehicleNumber(), syncDate,
                            new  LoadAsyncTask.AsyncTaskCallBackListener(){
                                @Override
                                public void postExecute(Boolean param) {
                                    progressRoutes.dismiss();
                                    if (param) {
                                        MainDrawerActivity.uncommitedChanges = false;
                                        MainDrawerActivity.needToUpdate = true;
                                        Toast.makeText(context, R.string.sync_finished, Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(context, R.string.can_not_get_data, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                    loadTask.execute();
                }
            });
            builder.setNegativeButton(R.string.dialog_no, null);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    /**
     * Перегруженный метод родительского класса. Возвращает layout action bar'a в зависимости от типа экрана
     */
    @Override
    protected int getActionBarLayout() {
        int actionBarId;
        switch (selectedPosition) {
            case SHOW_ADDRESS_LIST:
                actionBarId = R.layout.action_bar_main;
                break;
            case SHOW_MAP:
                actionBarId = R.layout.action_bar_map;
                break;
            case SHOW_PROFILE:
                actionBarId = R.layout.action_bar_map;
                break;
            case SHOW_SETTINGS:
                actionBarId = R.layout.action_bar_map;
                break;
            case LOGOUT:
                actionBarId =  R.layout.action_bar_login;
                startActivity(new Intent(this, AuthActivity.class));
                break;
            default:
                actionBarId = R.layout.action_bar_details;
                break;
        }
        return actionBarId;
    }

    /**
     * Метод для изменения внешнего вида action bar'а
     * Задает обработчики событий нажатия на кнопки в зависимоти от того, какие кнопки присутствуют в action bar'е
     */
    @Override
    public void customizeActionBar() {
        super.customizeActionBar();

        ImageView drawerBtn = (ImageView) findViewById(R.id.drawer_btn);
        if (drawerBtn != null)
            drawerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
                    if (!drawerOpen)
                        mDrawerLayout.openDrawer(Gravity.LEFT);
                    else
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                }
            });

        // по нажатию на кнопку "назад" возвращаться к списку заказов
        ImageView backBtn = (ImageView) findViewById(R.id.back_btn);
        if (backBtn != null)
            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectItem(0);
                }
            });

        // по нажатию на кнопку "обновить" показывать диалог выбора даты
        ImageView showDatePickerButton = (ImageView) findViewById(R.id.reload_btn);
        if (showDatePickerButton != null)
            showDatePickerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDatePickerDialog();
                }
            });

        // если задана дата, то показывать её в action bar'е слева
        TextView syncDateTextView = (TextView) findViewById(R.id.syncDate);
        if (syncDateTextView != null && DataStorage.getSelectedDate() != null)
            syncDateTextView.setText(new SimpleDateFormat("dd.MM.yyyy").format(DataStorage.getSelectedDate()));
    }

    /**
     * Используя ActionBarDrawerToggle, вызываем перегруженный метод при событиях onPostCreate() и onConfigurationChanged()...
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * Обработчик нажатия hardware-кнопки "назад"
     */
    @Override
    public void onBackPressed() {
        // удаяем идентификатор текущего экрана из стэка
        router.pop();

        // если стэк пуст, то значит в главном экране приложения - показываем список заказов
        if (router.size() == 0) {
            selectItem(SHOW_ADDRESS_LIST);
            return;
        }

        // получаем идентификатор предыдущего экрана
        ScreenIterator iterator = router.pop();

        if (iterator.position == SHOW_MAP) {
            // если идентификатор экрана - карты, то инициализируем карту с выбранным марщрутом
            showMap(iterator.route);
        } else if (iterator.position >= 0) {
            // если идентифкатор экрана положительный, т.е. это - элемент списка меню, то показываем экран для выбранного списка меню
            selectItem(iterator.position);
        } else {
            // во всех других случаях идентифкатор экрана отрицательный, т.е. это - не элемент списка меню, а экран карточки заказа
            // показываем карточку заказа с выбранным заказом
            showAddressCard(iterator.order);
        }
    }

    /**
     * Метод показа экрана в зависимости от выбранного элмента в меню
     * @param position идентификатор экрана
     */
    private void selectItem(int position) {
        // сохраняем идентификатор текущего экрана
        this.selectedPosition = position;

        // сохраняем в стэк идентификатор текущего экрана с выбранным маршрутом
        router.push(new ScreenIterator(position, null, selectedRoute));
        customizeActionBar();
        switch (position) {
            case SHOW_ADDRESS_LIST:
                showRoutesList();
                break;
            case SHOW_MAP:
                showMap(selectedRoute);
                break;
            case SHOW_PROFILE:
                showProfile();
                break;
            case SHOW_SETTINGS:
                showSettings();
                break;
            default:
                break;
        }

        // обновляем меню
        mDrawerList.setItemChecked(position, true);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    /**
     * Метод инициализации экрана со списком маршрутов
     */
    private void showRoutesList(){
        Fragment fragment = new RoutesListFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    /**
     * Метод инициализации карты с выбранным маршрутом
     * @param route маршрут
     */
    private void showMap(Route route){
        Fragment fragment = new RoutesMapFragment(route);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    /**
     * Метод инициализации экрана профиля
     */
    private void showProfile(){
        Fragment fragment = new ProfileFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    /**
     * Метод инициализации экрана настроек
     */
    private void showSettings(){
        Fragment fragment = new SettingsFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    /**
     * Метод показа диалога выбора даты
     */
    private void showDatePickerDialog(){
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dateDlg = new DatePickerDialog(MainDrawerActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        if (view.isShown()) {
                            Calendar cl = Calendar.getInstance();
                            cl.set(Calendar.YEAR, year);
                            cl.set(Calendar.MONTH, monthOfYear);
                            cl.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                            Date syncDate = new Date(cl.getTimeInMillis());
                            DataStorage.setSelectedDate(syncDate);

                            if (DataConnector.isOnline(MainDrawerActivity.this)) {
                                // если устройство подключено к сети интернет, то запускаем обновление
                                final ProgressDialog progressRoutes = new ProgressDialog(MainDrawerActivity.this);
                                progressRoutes.setMessage(getResources().getString(R.string.loading));
                                progressRoutes.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                progressRoutes.setCancelable(false);
                                progressRoutes.show();

                                // обновление данных выполняется в отдельном потоке
                                LoadAsyncTask loadTask = new LoadAsyncTask(
                                        MainDrawerActivity.this, DataStorage.getVehicleNumber(), syncDate,
                                        new  LoadAsyncTask.AsyncTaskCallBackListener(){
                                            @Override
                                            public void postExecute(Boolean param) {
                                                progressRoutes.dismiss();
                                                if (param) {
                                                    needToUpdate = true;
                                                    // если обновление прошло успешно, то по умолчанию показывается экран со списком заказов
                                                    selectItem(0);
                                                } else {
                                                    Toast.makeText(MainDrawerActivity.this, R.string.can_not_get_data, Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                loadTask.execute();
                            } else {
                                // если устройство не подключено к сети интернет, то показываем диалог проверки подключения
                                (new InternetSettingsDialog(MainDrawerActivity.this)).show();
                            }
                        }
                    }
                }, year, month, day);
        dateDlg.setCanceledOnTouchOutside(false);
        dateDlg.show();
    }

    /**
     * Метод инициализации карточки выбранного заказа
     * @param order заказ
     */
    public void showAddressCard(Order order) {
        // сохраняем идентификатор текущего экрана
        this.selectedPosition = SHOW_ADDRESS_DETAILS;
        // сохраняем в стэк идентификатор текущего экрана с выбранным заказом и маршрутом
        router.push(new ScreenIterator(SHOW_ADDRESS_DETAILS, order, selectedRoute));
        // меняем вид action bar'a
        customizeActionBar();
        Fragment fragment = new AddressCardDetailFragment(order);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    /**
     * Метод чтения к приватной переменной needToUpdate
     */
    public static boolean isNeedToUpdate() {
        return needToUpdate;
    }

    /**
     * Метод записи приватной переменной needToUpdate
     */
    public static void setNeedToUpdate(boolean res) {
        needToUpdate = res;
    }

    /**
     * Вспомогательная внутренняя структура для хранения информации о текущем экране. Используется в стэке router
     */
    private class ScreenIterator {
        int position;
        Order order;
        Route route;

        public ScreenIterator(int position, Order order, Route route){
            this.position = position;
            this.order = order;
            this.route = route;
        }
    }
}
