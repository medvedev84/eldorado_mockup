package ru.terralink.mvideo.android.async;

/**
 * абстрактный класс, наследуемый от AsyncTask, что гарантирует выполнение в отдельном потоке.
 * Особенность - в методе onPreExecute инициализирует перменную приложения
 * @author Медведев Константин
 */

import android.content.Context;
import android.os.AsyncTask;

import com.sybase.mobile.Application;

import ru.terralink.mvideo.android.data.DataConnector;

abstract public class NetworkAsyncTask extends AsyncTask<Void, Void, Boolean> {

    private Context context;
    private Application application;
    private AsyncTaskCallBackListener listener;

    public NetworkAsyncTask() {}

    public NetworkAsyncTask(Context context, AsyncTaskCallBackListener listener) {
        this.context = context;
        this.listener = listener;
    }

    /**
     *  Метод вызывает метод prepareApplicationObject у класса DataConnector и передаем ему на вход контекст.
     *  Т.о. гарантируется, что перед каждый запуском потока переменная application будет проинициализированна.
     */
    @Override
    protected void onPreExecute() {
        application = DataConnector.prepareApplicationObject(context);
    }

    @Override
    protected void onPostExecute(Boolean param) {
        listener.postExecute(param);
    }

    public Context getContext() {
        return context;
    }

    protected Application getApplication() {
        return application;
    }

    public interface AsyncTaskCallBackListener {
        public void postExecute(Boolean param);
    }

}
