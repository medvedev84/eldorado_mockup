package ru.terralink.mvideo.android;

/**
 * Fragment для показа списка маршрутов
 * @author Медведев Константин
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import ru.terralink.mvideo.android.adapter.RoutesExpandableListAdapter;
import ru.terralink.mvideo.android.data.DataStorage;
import ru.terralink.mvideo.android.model.Order;

public class RoutesListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_route_list, container, false);

        TextView syncDateTextView = (TextView) rootView.findViewById(R.id.syncDate);
        if (syncDateTextView != null)
            syncDateTextView.setText(new SimpleDateFormat("dd.MM.yyyy").format(DataStorage.getSelectedDate()));

        // если требуются обновленные данные, то загружаем их
        if (MainDrawerActivity.isNeedToUpdate()) {
            DataStorage.loadData(getActivity());
            MainDrawerActivity.setNeedToUpdate(false);
        }

        RoutesExpandableListAdapter adapter = new RoutesExpandableListAdapter(getActivity(), DataStorage.getRoutes());
        final ExpandableListView expListView = (ExpandableListView) rootView.findViewById(R.id.route_list);
        expListView.setAdapter(adapter);
        // обработчик нажатия на младшие элементы вложенного списка
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                // получаем заказ из вспомогательного класса-хранилища данных приложения
                Order order = DataStorage.getRoutes().get(groupPosition).getOrders().get(childPosition);
                // показываем карточку заказа
                ((MainDrawerActivity) getActivity()).showAddressCard(order);
                return false;
            }
        });
        // обработчик нажатия на старшие элементы вложенного списка
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                // сохраняем выбранный маршрут как текущий
                MainDrawerActivity.selectedRoute =  DataStorage.getRoutes().get(groupPosition);
                // сворачиваем все остальные старшие элементы списка
                for  (int i=0; i<expListView.getCount(); i++){
                    if (i!=groupPosition)
                        expListView.collapseGroup(i);
                }
            }
        });
        expListView.expandGroup(0);
        return rootView;
    }
}
