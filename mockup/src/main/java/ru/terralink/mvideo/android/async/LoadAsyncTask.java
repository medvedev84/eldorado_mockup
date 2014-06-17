package ru.terralink.mvideo.android.async;

/**
 * Класс для загрузки данных в фоне. Т.к. наследуется от NetworkAsyncTask, то должен
 * перегружать метод doInBackground, который автоматически будет исполняться в отдельном потоке.
 * @author Медведев Константин
 */

import android.content.Context;

import java.sql.Date;

public class LoadAsyncTask extends NetworkAsyncTask {

    // номер авто, для которого получаются данные
    private String vehicle;
    // дата, на которую надо получить данные
    private Date syncDate;

    public LoadAsyncTask(Context context, String vehicle, Date syncDate, AsyncTaskCallBackListener listener) {
        super(context, listener);
        this.vehicle = vehicle;
        this.syncDate = syncDate;
    }

    /**
     *  Метод вызывает метод load у класса DataConnector и передаем ему на вход дату, номер авто и ссылку на приложение
     *  @param params массив объектов-параметров
     */
    @Override
    protected Boolean doInBackground(Void... params) {
        /*
        *   just return true as stub
        return DataConnector.getInstance().load(syncDate, vehicle, getApplication());
        */
        return true;
    }
}
