package ru.terralink.mvideo.android;
/**
 * Диалог проверки настроек подключения к сети интернет
 * @author Медведев Константин
 */
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class InternetSettingsDialog {

    private AlertDialog alertDialog = null;
    private Context context;

    public InternetSettingsDialog(Context context){
        this.context = context;
        init();
    }

    /**
     * Метод инициализации диалога
     * По нажатию на кнопку "Да" открывает настройки подключения к сети устройства
     */
    private void init() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.internet_settings_dialog_title);
        builder.setMessage(R.string.internet_settings_dialog_body);
        builder.setPositiveButton(R.string.dialog_yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                context.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            }
        });
        builder.setNegativeButton(R.string.dialog_no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(context, R.string.offline_mode, Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog = builder.create();
    }

    /**
     * Метод показа диалога
     */
    public void show(){
        alertDialog.show();
    }

}
