package ru.terralink.mvideo.android.async;

/**
 * Класс для обновления статуса в фоне. Т.к. наследуется от NetworkAsyncTask, то должен
 * перегружать метод doInBackground, который автоматически будет исполняться в отдельном потоке.
 * @author Медведев Константин
 */

import android.content.Context;

import ru.terralink.mvideo.android.model.Order;

public class UpdateStatusAsyncTask extends NetworkAsyncTask {

    // заказ, статус которого надо обновить
    private Order order;
    //признак моментального обновления (иначе - работа в офф-лайн режиме)
    boolean synchronizeNow = false;

    public UpdateStatusAsyncTask(Context context, Order order, boolean synchronizeNow, AsyncTaskCallBackListener listener) {
        super(context, listener);
        this.order = order;
        this.synchronizeNow = synchronizeNow;
    }

    /**
     *  Метод вызывает метод updateStatus у класса DataConnector и передаем ему на вход заказ и признак офф-лайн или он-лайн режима
     *  @param params массив объектов-параметров
     */
    @Override
    protected Boolean doInBackground(Void... params) {
         /*
        *   just return true as stub
        return DataConnector.getInstance().updateStatus(order, synchronizeNow);
        */
        return true;
    }
}
