package ru.terralink.mvideo.android.data;

/**
 * Класс-помощник для хранения настроек приложения
 * @author Медведев Константин
 */

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SettingsStorage {

    // максимальный таймаут (в секундах)
    public static final int MAX_TIMEOUT = 300;
    // таймаут по умолчанию (в секундах)
    public static final int DEFAULT_TIMEOUT = 60;
    // имя приложения
    public static final String DEFAULT_APP_NAME = "mvideo4";
    // ip адрес сервера
    public static final String DEFAULT_SERVER_HOST = "10.100.100.3";
    // порт сервера
    public static final int DEFAULT_SERVER_PORT = 5001;
    // признак "шифрованного" подключения
    public static final boolean DEFAULT_IS_HTTPS = false;

    // имя файла для хранения настроек
    public static final String SETTINGS_FILE_NAME = "MvideoSettings";
    // имя настройки для хранения имени приложения
    public static final String SETTINGS_APP_NAME = "AppName";
    // имя настройки для хранения адреса сервера
    public static final String SETTINGS_SERVER_HOST = "ServerHost";
    // имя настройки для хранения порта сервера
    public static final String SETTINGS_SERVER_PORT = "ServerPort";
    // имя настройки для хранения признака шифрованного подключения
    public static final String SETTINGS_IS_HTTPS = "IsHttps";
    // имя настройки для хранения таймаута
    public static final String SETTINGS_TIMEOUT = "Timeout";

    /**
     *  Метод для записи булевской переменной в настройки
     *  @param context контекст приложения
     *  @param type имя переменной
     *  @param value значение по умолчанию
     */
    public static void saveBooleanValue(Context context, String type, boolean value){
        SharedPreferences settings = context.getSharedPreferences(SETTINGS_FILE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(type, value);
        editor.commit();
    }

    /**
     *  Метод для получения булевской переменной из настроек
     *  @param context контекст приложения
     *  @param type имя переменной
     *  @param value значение по умолчанию
     */
    public static boolean getBooleanValue(Context context, String type, boolean value){
        SharedPreferences settings = context.getSharedPreferences(SETTINGS_FILE_NAME, Activity.MODE_PRIVATE);
        return settings.getBoolean(type, value);
    }

    /**
     *  Метод для записи строковой переменной в настройки
     *  @param context контекст приложения
     *  @param type имя переменной
     *  @param value значение по умолчанию
     */
    public static void saveStringValue(Context context, String type, String value){
        SharedPreferences settings = context.getSharedPreferences(SETTINGS_FILE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(type, value);
        editor.commit();
    }

    /**
     *  Метод для получения строковой переменной из настроек
     *  @param context контекст приложения
     *  @param type имя переменной
     *  @param value значение по умолчанию
     */
    public static String getStringValue(Context context, String type, String value){
        SharedPreferences settings = context.getSharedPreferences(SETTINGS_FILE_NAME, Activity.MODE_PRIVATE);
        return settings.getString(type, value);
    }

    /**
     *  Метод для записи целочисленной переменной в настройки
     *  @param context контекст приложения
     *  @param type имя переменной
     *  @param value значение по умолчанию
     */
    public static void saveIntValue(Context context, String type, int value){
        SharedPreferences settings = context.getSharedPreferences(SETTINGS_FILE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(type, value);
        editor.commit();
    }

    /**
     *  Метод для получения целочисленной переменной из настроек
     *  @param context контекст приложения
     *  @param type имя переменной
     *  @param value значение по умолчанию
     */
    public static int getIntValue(Context context, String type, int value){
        SharedPreferences settings = context.getSharedPreferences(SETTINGS_FILE_NAME, Activity.MODE_PRIVATE);
        return settings.getInt(type, value);
    }


}
