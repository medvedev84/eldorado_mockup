package ru.terralink.mvideo.android;
/**
 * Fragment для показа профиля
 * @author Медведев Константин
 */
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import ru.terralink.mvideo.android.data.DataStorage;
import ru.terralink.mvideo.android.model.Route;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Любой фрагмент должен иметь пустой конструктор по умолчанию
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView dateText = (TextView)rootView.findViewById(R.id.profile_date);
        dateText.setText(new SimpleDateFormat("dd.MM.yyyy").format(DataStorage.getSelectedDate()));
        TextView vehicleText = (TextView)rootView.findViewById(R.id.profile_vehicle);
        vehicleText.setText(DataStorage.getVehicleNumber());

        if (DataStorage.getRoutes().size() > 0 && DataStorage.getRoutes().get(0) != null) {
            // если есть данные о маршрутах, то инициализируем ими профиль
            Route route = DataStorage.getRoutes().get(0);
            TextView nameText = (TextView)rootView.findViewById(R.id.profile_name);
            nameText.setText(route.getExpeditorName());
            TextView courierText = (TextView)rootView.findViewById(R.id.courier_name);
            courierText.setText(route.getDriverName());
        } else {
            // если нет данных о маршрутах, то отображаем соответствующее сообщение
            TextView nameText = (TextView)rootView.findViewById(R.id.profile_name);
            nameText.setText(getString(R.string.no_data));
        }

        // по нажатию на кнопку "Выход" показывает стартовую activity
        Button logoutBtn = (Button) rootView.findViewById(R.id.logout_btn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AuthActivity.class));
            }
        });
        return rootView;
    }
}
