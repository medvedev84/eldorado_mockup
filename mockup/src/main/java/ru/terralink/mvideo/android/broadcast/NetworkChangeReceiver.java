package ru.terralink.mvideo.android.broadcast;

/**
 * Класс для получения оповещения о смене статуса подключения к сети интернет. Если устройство получило или потеряло подключение
 *  к сети интернет, то этот класс получит сообщение и вызовет метод onReceive
 * @author Медведев Константин
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import ru.terralink.mvideo.android.data.DataConnector;

public class NetworkChangeReceiver extends BroadcastReceiver {

    /**
     *  Метод показывает сообщение о смене статуса подключения к сети интернет
     *  @param context контекст приложения
     *  @param intent
     */
    @Override
    public void onReceive(final Context context, final Intent intent) {
        String status = DataConnector.getConnectivityStatusString(context);
        Toast.makeText(context, status, Toast.LENGTH_SHORT).show();
    }
}
