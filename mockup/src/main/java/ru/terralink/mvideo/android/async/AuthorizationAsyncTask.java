package ru.terralink.mvideo.android.async;

/**
 * Класс для выполнения авторизации в фоне. Т.к. наследуется от NetworkAsyncTask, то должен
 * перегружать метод doInBackground, который автоматически будет исполняться в отдельном потоке.
 * @author Медведев Константин
 */

import android.content.Context;

public class AuthorizationAsyncTask extends NetworkAsyncTask {

    // логин пользователя
    private String login;
    // пароль пользователя
    private String password;
    // номер авто
    private String vehicle;

    public AuthorizationAsyncTask(Context context, String login, String password, String vehicle, AsyncTaskCallBackListener listener) {
        super(context, listener);
        this.login = login;
        this.password = password;
        this.vehicle = vehicle;
    }

    /**
     *  Метод вызывает метод auth у класса DataConnector и передаем ему на вход логин, пароль, номер авто и ссылку на приложение
     *  @param params массив объектов-параметров
     */
    @Override
    protected Boolean doInBackground(Void... params) {
        /*
        *   just return true as stub
        return DataConnector.getInstance().auth(login, password, vehicle, getApplication());
        */
        return true;
    }

}
