package ru.terralink.mvideo.android;

/**
 * Стартовая activity для запуска приложения. Содержит форму входа с тремя полями и кнопкой.
 * @author Медведев Константин
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.terralink.mvideo.android.async.AuthorizationAsyncTask;
import ru.terralink.mvideo.android.data.DataConnector;
import ru.terralink.mvideo.android.data.DataStorage;

public class AuthActivity extends ActionBarMutableActivity implements View.OnClickListener  {

    /** Поле ввода для логина **/
    private EditText loginText;
    /** Поле ввода для пароля **/
    private EditText passwordText;
    /** Поле ввода для номера авто **/
    private EditText vehicleText;
    /** Кнопка для старта аутентификации **/
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        setFinishOnTouchOutside(false);

        loginText = (EditText) findViewById(R.id.login_text);
        loginText.setText("tedt");
        passwordText = (EditText) findViewById(R.id.password_text);
        passwordText.setText("test");
        vehicleText = (EditText) findViewById(R.id.vehicle);
        vehicleText.setText("М603РС77");

        loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);
    }

    /**
     *  Обработчик события нажатия кнопки "назад"
     *  При переходе на стартовую activity, возврат на предыдущие экраны не возможен
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    /**
     * Перегруженный метод родительского класса. Возвращает layout action bar'a для экрана логина
     */
    @Override
    protected int getActionBarLayout() {
        return R.layout.action_bar_login;
    }

    /**
     * Обработчик нажатия кнопки формы. Если имеется подключение к сети интернет, то начинается авторизация пользователя,
     * иначе показывается диалог с предложение проверить настройки подключения к сети интернет
     */
    @Override
    public void onClick(View v) {
        final String login = loginText.getText().toString();
        final String password = passwordText.getText().toString();
        final String vehicle = vehicleText.getText().toString();

        DataStorage.setVehicleNumber(vehicle);

        if (DataConnector.isOnline(this)) {
            final ProgressDialog progressRoutes = new ProgressDialog(this);
            progressRoutes.setMessage(getResources().getString(R.string.authenticating));
            progressRoutes.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressRoutes.setCancelable(false);
            progressRoutes.show();
            new AuthorizationAsyncTask(
                    this, login, password, vehicle,
                    new  AuthorizationAsyncTask.AsyncTaskCallBackListener(){
                        @Override
                        public void postExecute(Boolean param) {
                            progressRoutes.dismiss();
                            if (param) {
                                startActivity(new Intent(AuthActivity.this, MainDrawerActivity.class));
                            } else {
                                Toast.makeText(AuthActivity.this, R.string.can_not_login, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).execute();
        } else {
            (new InternetSettingsDialog(this)).show();
        }
    }
}
