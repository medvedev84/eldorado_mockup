package ru.terralink.mvideo.android.adapter;

/**
 * Класс-адаптер для работы с массивом статусов. С помощью этого адаптера можно инициализировать различные виды списков в приложении
 * @author Медведев Константин
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import ru.terralink.mvideo.android.R;
import ru.terralink.mvideo.android.model.OrderStatus;

public class StatusListAdapter  extends ArrayAdapter<OrderStatus> {
    // контекст приложения
    private final Context context;
    // массив статусов
    private final OrderStatus[] values;

    public StatusListAdapter(Context context, OrderStatus[] values) {
        super(context, R.layout.list_item_status, values);
        this.context = context;
        this.values = values;
    }

    /**
     *  Метод возвращает представление для элемента списка. Представление строится на основе разметки в файле  list_item_status и состоит только из надписи
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_status, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.statusName);
        textView.setText(values[position].getName());
        return rowView;
    }
}