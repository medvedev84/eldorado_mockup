package ru.terralink.mvideo.android.data;

/**
 * Класс-помощник для подключения к серверу
 * @author Медведев Константин
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.sybase.mobile.Application;
import com.sybase.mobile.ConnectionProperties;
import com.sybase.mobile.DefaultApplicationCallback;
import com.sybase.mobile.RegistrationStatus;
import com.sybase.persistence.ConnectionProfile;
import com.sybase.persistence.DefaultCallbackHandler;
import com.sybase.persistence.LoginCredentials;

import java.sql.Date;

import ru.terralink.mvideo.android.R;
import ru.terralink.mvideo.android.model.Order;
import ru.terralink.mvideo.sap.Mvideo5DB;
import ru.terralink.mvideo.sap.OperDay;
import ru.terralink.mvideo.sap.OperDaySubscription;
import ru.terralink.mvideo.sap.UpdateStatus;
import ru.terralink.mvideo.sap.UpdateStatusSubscription;


public class DataConnector {

    private static volatile DataConnector dataConnector;

    // тэг логгера
    private static String APP_TAG = "mvideo4";

    // метод возвращает только один экземпляр класса (singletone)
    public static DataConnector getInstance() {
        synchronized (DataConnector.class) {
            if (dataConnector == null) {
                dataConnector = new DataConnector();
            }
        }
        return dataConnector;
    }

    // метод подготовки соединения с сервером
    public static Application prepareApplicationObject(Context context) {
        String appName = SettingsStorage.getStringValue(context, SettingsStorage.SETTINGS_APP_NAME, SettingsStorage.DEFAULT_APP_NAME);
        Application app = Application.getInstance();
        if (app.getApplicationIdentifier() == null) {
            app.setApplicationIdentifier(appName);
        }
        if (app.getApplicationContext() == null) {
            app.setApplicationContext(context);
        }
        return app;
    }

    /**
     *  Метод аутентификации по заданным параметрам
     *  @param login логин
     *  @param password пароль
     *  @param vehicle номер авто
     *  @param app экземпляр приложения
     */
    public boolean auth(String login, String password, String vehicle, Application app) {
        // получения адреса сервера из хранилища приложения
        String serverHost = SettingsStorage.getStringValue(app.getApplicationContext(), SettingsStorage.SETTINGS_SERVER_HOST, SettingsStorage.DEFAULT_SERVER_HOST);
        // получения порта сервера из хранилища приложения
        int serverPort = SettingsStorage.getIntValue(app.getApplicationContext(), SettingsStorage.SETTINGS_SERVER_PORT, SettingsStorage.DEFAULT_SERVER_PORT);
        // получения типа подключения из хранилища приложения
        boolean isHttps = SettingsStorage.getBooleanValue(app.getApplicationContext(), SettingsStorage.SETTINGS_IS_HTTPS, SettingsStorage.DEFAULT_IS_HTTPS);
        // получения таймаута из хранилища приложения
        int timeout = SettingsStorage.getIntValue(app.getApplicationContext(), SettingsStorage.SETTINGS_TIMEOUT, SettingsStorage.DEFAULT_TIMEOUT);

        boolean result = false;
        app.setApplicationCallback(new DefaultApplicationCallback());
        Mvideo5DB.registerCallbackHandler(new DefaultCallbackHandler());
        Mvideo5DB.setApplication(app);
        Mvideo5DB.getSynchronizationProfile().setServerName(serverHost);

        // задание параметров подключения
        ConnectionProperties connProps = app.getConnectionProperties();
        LoginCredentials loginCredentials = new LoginCredentials(login, password);

        connProps.setLoginCredentials(loginCredentials);
        connProps.setServerName(serverHost);
        connProps.setPortNumber(serverPort);
        connProps.setNetworkProtocol(isHttps ? "https" : "http");

        try {
            app.registerApplication(timeout);
            result = true;
        } catch (Exception e) {
            Log.e(APP_TAG, e.getMessage());
        }

        return result;
    }

    /**
     *  Метод получения данных по опер. дню по заданным параметрам
     *  @param syncDate дата опер. дня
     *  @param vehicle номер авто
     *  @param app экземпляр приложения
     */
    public static boolean load(final Date syncDate, final String vehicle, Application app) {
        int timeout = SettingsStorage.getIntValue(app.getApplicationContext(), SettingsStorage.SETTINGS_TIMEOUT, SettingsStorage.DEFAULT_TIMEOUT);

        boolean result = false;
        try {
            // если БД не создана, то создаем, иначе - просто устанавливаем подключение
            if (app.getRegistrationStatus() != RegistrationStatus.REGISTERED) {
                app.registerApplication(timeout);
                if (!Mvideo5DB.databaseExists()) {
                    Mvideo5DB.createDatabase();
                }
            } else {
                Mvideo5DB.openConnection();
                app.startConnection(timeout);
            }

            if (app.getRegistrationStatus() == RegistrationStatus.REGISTERED) {
                // задаем параметры подписки для получения данных по опер. дню
                OperDaySubscription params = new OperDaySubscription();
                params.setSp_numb(vehicle);
                params.setSp_date(syncDate);

                // очизаем предыдущие подписки
                for (OperDaySubscription s: OperDay.getSubscriptions()){
                    OperDay.removeSubscription(s);
                }
                // задаем новые параметры подписки
                OperDay.addSubscription(params);

                /*
                * код и комментарий Михаила Марочкина:
                * trick to synchronize under supAdmin account
                * reason - доступ к базе возможен под логином администратора
                * reference:
                * http://benxbrain.com/en/forum/LDAP-Synchronization-using-the-username-and-activation-code-in-android-native-app-thread-1-3295103.htm
                */
                String serverHost = SettingsStorage.getStringValue(app.getApplicationContext(), SettingsStorage.SETTINGS_SERVER_HOST, SettingsStorage.DEFAULT_SERVER_HOST);

                LoginCredentials newcred=new LoginCredentials("supAdmin","supAdmin");
                ConnectionProfile connectionProfile = Mvideo5DB.getSynchronizationProfile();
                connectionProfile.setServerName(serverHost);
                connectionProfile.setPortNumber(2480);
                connectionProfile.setAsyncReplay(true);
                connectionProfile.setDomainName("default");
                connectionProfile.setCredentials(newcred);
                connectionProfile.save();
                Mvideo5DB.subscribe();
                Mvideo5DB.submitPendingOperations();

                Mvideo5DB.disableChangeLog();
                Mvideo5DB.synchronize();
                Mvideo5DB.enableChangeLog();
            }

            result = true;
        } catch (Exception e) {
            Log.e(APP_TAG, e.getMessage());
        }
        return result;
    }


    /**
     *  Метод обновлени статуса заказа
     *  @param order заказ
     *  @param synchronizeNow параметр указывает - синхронихировать сейчас или работать офф-лайн
     */
    public static boolean updateStatus(Order order, boolean synchronizeNow) {
        boolean result = false;
        try {
            UpdateStatusSubscription params = new UpdateStatusSubscription();
            // если комментарий не задан, передаем строку "test comment"
            params.setSp_comment(order.getComment() != null ? order.getComment() :
                    order.getStrDelay() != null ? order.getStrDelay() : "test comment");
            // номер маршрута
            params.setSp_fo(order.getRouteNumber());
            // номер заказа
            params.setSp_fu(order.getOrderNumber());
            // код статуса
            params.setSp_code(order.getStatus().getCode());
            UpdateStatus.addSubscription(params);
            UpdateStatus.submitPendingOperations();
            // если работа в онлайн, то запускаем синхронизацию
            if (synchronizeNow)
                Mvideo5DB.synchronize();
            result = true;
        }
        catch (Exception e) {
            Log.e(APP_TAG, e.getMessage());
        }
        return result;
    }

    /**
     *  Метод определяет, подключено устройство к сети интернета или нет
     *  @param context контекст приложения
     */
    public static boolean isOnline(Context context){
        /*
        *   just return true as stub
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
        */
        return true;
    }

    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;

    /**
     *  Метод возвращает тип доступного подключения
     *  @param context контекст приложения
     */
    public static int getConnectivityStatus(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;

            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;
        }
        return TYPE_NOT_CONNECTED;
    }

    /**
     *  Метод возвращает сообщение о доступном подключении
     *  @param context контекст приложения
     */
    public static String getConnectivityStatusString(Context context) {
        int conn = getConnectivityStatus(context);
        String status = null;
        if (conn == TYPE_WIFI) {
            status = context.getString(R.string.wifi_enabled);
        } else if (conn == TYPE_MOBILE) {
            status = context.getString(R.string.mobile_internet_enabled);
        } else if (conn == TYPE_NOT_CONNECTED) {
            status = context.getString(R.string.not_connected);
        }
        return status;
    }

}