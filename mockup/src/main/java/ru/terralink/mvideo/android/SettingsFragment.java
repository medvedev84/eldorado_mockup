package ru.terralink.mvideo.android;

/**
 * Fragment для показа экрана настроек
 * @author Медведев Константин
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ru.terralink.mvideo.android.data.DataStorage;
import ru.terralink.mvideo.android.data.SettingsStorage;

public class SettingsFragment extends Fragment {

    /** Поле ввода для адреса сервера **/
    private EditText editTextServerHost;
    /** Поле ввода для порта сервера **/
    private EditText editTextServerPort;
    /** Поле ввода для имени приложения **/
    private EditText editTextAppName;
    /** Селектор для выбора http соединения **/
    private RadioButton radioButtonHttp;
    /** Селектор для выбора https соединения **/
    private RadioButton radioButtonHttps;
    /** Ползунок для выбора таймаута **/
    private SeekBar seekBarTimeout;
    /** Надпись для отображения величины таймаута **/
    private TextView textViewTimeout;
    /** Кнопка для восстановления настроек по умолчанию **/
    private Button buttonRestoreDefaults;
    /** Кнопка для сохранения настроек **/
    private Button buttonSave;

    public SettingsFragment() {
        // Любой фрагмент должен иметь пустой конструктор по умолчанию
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        editTextServerHost = (EditText) rootView.findViewById(R.id.editTextServerHost);
        editTextServerPort = (EditText) rootView.findViewById(R.id.editTextServerPort);
        editTextAppName = (EditText) rootView.findViewById(R.id.editTextAppName);
        radioButtonHttp = (RadioButton) rootView.findViewById(R.id.radioButtonHttp);
        radioButtonHttps = (RadioButton) rootView.findViewById(R.id.radioButtonHttps);
        seekBarTimeout = (SeekBar) rootView.findViewById(R.id.seekBarTimeout);
        textViewTimeout = (TextView) rootView.findViewById(R.id.textViewTimeout);

        /* ------- Инициализируем поля ввода из сохраненных настроек -------*/
        String serverHost = SettingsStorage.getStringValue(getActivity(), SettingsStorage.SETTINGS_SERVER_HOST, SettingsStorage.DEFAULT_SERVER_HOST);
        editTextServerHost.setText(serverHost);

        int serverPort = SettingsStorage.getIntValue(getActivity(), SettingsStorage.SETTINGS_SERVER_PORT, SettingsStorage.DEFAULT_SERVER_PORT);
        editTextServerPort.setText(String.valueOf(serverPort));

        String appName = SettingsStorage.getStringValue(getActivity(), SettingsStorage.SETTINGS_APP_NAME, SettingsStorage.DEFAULT_APP_NAME);
        editTextAppName.setText(appName);


        /* ------- Инициализируем селекторы -------*/
        boolean isHttps = SettingsStorage.getBooleanValue(getActivity(), SettingsStorage.SETTINGS_IS_HTTPS, SettingsStorage.DEFAULT_IS_HTTPS);
        if (isHttps)
            radioButtonHttps.setChecked(true);
        else
            radioButtonHttp.setChecked(true);

        /* ------- Инициализируем ползунок таймаута -------*/
        seekBarTimeout.setMax(SettingsStorage.MAX_TIMEOUT);
        int timeout = SettingsStorage.getIntValue(getActivity(), SettingsStorage.SETTINGS_TIMEOUT, SettingsStorage.DEFAULT_TIMEOUT);
        seekBarTimeout.setProgress(timeout);
        textViewTimeout.setText(String.valueOf(timeout));

        SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar bar) {
                int timeout = seekBarTimeout.getProgress();
                textViewTimeout.setText(String.valueOf(timeout));
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {}

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {}
        };
        seekBarTimeout.setOnSeekBarChangeListener(seekBarListener);

        /* ------- Инициализируем кнопки формы и их обработчики -------*/
        buttonSave = (Button) rootView.findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsStorage.saveStringValue(getActivity(), SettingsStorage.SETTINGS_APP_NAME, editTextAppName.getText().toString());
                SettingsStorage.saveStringValue(getActivity(), SettingsStorage.SETTINGS_SERVER_HOST, editTextServerHost.getText().toString());
                try {
                    int port = Integer.parseInt(editTextServerPort.getText().toString());
                    SettingsStorage.saveIntValue(getActivity(), SettingsStorage.SETTINGS_SERVER_PORT, port);
                } catch (NumberFormatException e) {
                    editTextServerPort.setError(getString(R.string.settings_server_port_not_number));
                    editTextServerPort.requestFocus();
                }
                SettingsStorage.saveBooleanValue(getActivity(), SettingsStorage.SETTINGS_IS_HTTPS, radioButtonHttps.isChecked());
                SettingsStorage.saveIntValue(getActivity(), SettingsStorage.SETTINGS_TIMEOUT, seekBarTimeout.getProgress());

                Toast.makeText(getActivity(), R.string.settings_saved, Toast.LENGTH_SHORT).show();
            }
        });

        buttonRestoreDefaults = (Button) rootView.findViewById(R.id.buttonRestoreDefaults);
        buttonRestoreDefaults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsStorage.saveStringValue(getActivity(), SettingsStorage.SETTINGS_APP_NAME, SettingsStorage.DEFAULT_APP_NAME);
                editTextAppName.setText(SettingsStorage.DEFAULT_APP_NAME);

                SettingsStorage.saveStringValue(getActivity(), SettingsStorage.SETTINGS_SERVER_HOST, SettingsStorage.DEFAULT_SERVER_HOST);
                editTextServerHost.setText(SettingsStorage.DEFAULT_SERVER_HOST);

                SettingsStorage.saveIntValue(getActivity(), SettingsStorage.SETTINGS_SERVER_PORT, SettingsStorage.DEFAULT_SERVER_PORT);
                editTextServerPort.setText(String.valueOf(SettingsStorage.DEFAULT_SERVER_PORT));

                SettingsStorage.saveBooleanValue(getActivity(), SettingsStorage.SETTINGS_IS_HTTPS, SettingsStorage.DEFAULT_IS_HTTPS);
                if (SettingsStorage.DEFAULT_IS_HTTPS)
                    radioButtonHttps.setChecked(true);
                else
                    radioButtonHttp.setChecked(true);

                SettingsStorage.saveIntValue(getActivity(), SettingsStorage.SETTINGS_TIMEOUT, SettingsStorage.DEFAULT_TIMEOUT);
                seekBarTimeout.setProgress(SettingsStorage.DEFAULT_TIMEOUT);
                textViewTimeout.setText(String.valueOf(SettingsStorage.DEFAULT_TIMEOUT));

                Toast.makeText(getActivity(), R.string.settings_restored, Toast.LENGTH_SHORT).show();
            }
        });

        /* ------- Инициализируем форму показа логов сообщения -------*/
        final TextView textViewLog = (TextView) rootView.findViewById(R.id.textViewLog);
        Button buttonShowLog = (Button) rootView.findViewById(R.id.buttonShowLog);
        buttonShowLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // получаем логи работы отрисовщика маршрутов
                    Process process = Runtime.getRuntime().exec("logcat -v time -d RoutesDrawer:I *:S");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                    StringBuilder log=new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        log.append(line);
                    }

                    // отображаем логи на экране
                    textViewLog.setText(log.toString());
                } catch (IOException e) {
                    Toast.makeText(getActivity(), R.string.settings_show_log_error, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // кнопка очистки формы показа логов
        Button buttonClearLog = (Button) rootView.findViewById(R.id.buttonClearLog);
        buttonClearLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewLog.setText("");
            }
        });

        Button buttonResetData = (Button)rootView.findViewById(R.id.buttonResetData);
        buttonResetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataStorage.resetData();
            }
        });

        return rootView;
    }

}
