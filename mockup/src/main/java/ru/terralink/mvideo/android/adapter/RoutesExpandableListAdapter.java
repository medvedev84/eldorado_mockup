package ru.terralink.mvideo.android.adapter;

/**
 * Класс-адаптер для работы с вложенным списком маршрутов. Старшие элементы списка - маршруты, вложенные элементы - заказы, относящиеся к соответствующему маршруту
 * @author Медведев Константин
 */

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import ru.terralink.mvideo.android.R;
import ru.terralink.mvideo.android.UpdateStatusDialog;
import ru.terralink.mvideo.android.data.DataStorage;
import ru.terralink.mvideo.android.model.Order;
import ru.terralink.mvideo.android.model.OrderStatus;
import ru.terralink.mvideo.android.model.Route;

public class RoutesExpandableListAdapter extends BaseExpandableListAdapter {
    // контекст приложения
    private Context context;
    // список маршрутов
    private List<Route> routes;

    public RoutesExpandableListAdapter(Context context, List<Route> routes) {
        this.context = context;
        this.routes = routes;
    }

    /**
     *  Метод возвращает количество старших элементов
     */
    @Override
    public int getGroupCount() {
        return this.routes.size();
    }

    /**
     *  Метод возвращает количество вложенных элементов для выбранного старшего элемента
     *  @param groupPosition номер старшего элемента в списке
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        if (this.routes.size() > 0) {
            Route route = this.routes.get(groupPosition);
            if ( route!= null)
                return this.routes.get(groupPosition).getOrders().size();
        }
        return 0;
    }

    /**
     *  Метод возвращает объект старшего элемента
     *  @param groupPosition номер старшего элемента в списке
     */
    @Override
    public Object getGroup(int groupPosition) {
        return this.routes.get(groupPosition);
    }

    /**
     *  Метод возвращает объект вложенного элемента
     *  @param groupPosition номер старшего элемента в списке
     *  @param childPosition номер вложенного элемента в списке
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.routes.get(groupPosition).getOrders().get(childPosition);
    }

    /**
     *  Метод возвращает идентификатор старшего элемента
     *  @param groupPosition номер старшего элемента в списке
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     *  Метод возвращает идентификатор вложенного элемента
     *  @param groupPosition номер старшего элемента в списке
     *  @param childPosition номер вложенного элемента в списке
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     *  Метод возвращает представление для старшего элемента списка.
     *  @param groupPosition номер старшего элемента в списке
     *  @param isExpanded признак - распахнут данный элемент или свернут
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        // получаем объект-маршрут по выбранному старшему элементу списка
        Route route = (Route) getGroup(groupPosition);

        // формируем надпись для элемента списка - номер + дата
        String headerTitle = route.getNumberReduced();
        String deadline = route.getStrStartDate() != null ? ", с " + route.getStrStartDate() + " до " + route.getStrEndDate() : "";
        if (convertView == null) {
            // получаем разметку из файла list_row_group_route.xml
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_row_group_route, null);
        }
        TextView lblListHeader = (TextView) convertView.findViewById(R.id.routeName);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle + deadline);
        return convertView;
    }

    /**
     *  Метод возвращает представление для вложенного элемента списка.
     *  @param groupPosition номер старшего элемента в списке
     *  @param childPosition номер вложенного элемента списка
     */
    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        // получаем объект заказа по номеру выбранного старшего элемента и номеру вложенного элемента
        final Order order = (Order) getChild(groupPosition, childPosition);

        if (convertView == null) {
            // получаем разметку из файла list_row_details_address.xml
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_row_details_address, null);
        }

        // формаируем представление элемента
        TextView txtOrderId = (TextView) convertView.findViewById(R.id.orderId);
        txtOrderId.setText(String.valueOf(order.getId())+".");

        TextView txtAddress = (TextView) convertView.findViewById(R.id.address);
        txtAddress.setText(order.getAddress());

        final TextView txtStatus = (TextView) convertView.findViewById(R.id.status);
        txtStatus.setText(order.getStatus().getName());
        txtStatus.setTextColor(order.getStatus().getColor());

        TextView txtNumber = (TextView) convertView.findViewById(R.id.number);
        txtNumber.setText(order.getOrderNumberReduced());

        TextView txtDeadline = (TextView) convertView.findViewById(R.id.deadline);
        txtDeadline.setText("с " + order.getStrStartDate() + " до " + order.getStrEndDate());

        final TextView txtDelay = (TextView) convertView.findViewById(R.id.status_comment);
        // устанавливаем цвет надписи в зависимости от статуса
        txtDelay.setTextColor(order.getStatus().getColor());
        // для заказа в статусе "задержка" указываем время задержки
        if (order.getStatus() == OrderStatus.Z_DELAY) {
            txtDelay.setText(DataStorage.getDelayedOrders().get(order.getOrderNumber()).getStrDelay());
        }

        // устанавливаем обработчик события onClick для надписи
        View statusPane = convertView.findViewById(R.id.statusPane);
        statusPane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // показывает диалог обновления статуса
                UpdateStatusDialog updateDialog = new UpdateStatusDialog(context, order, txtStatus, txtDelay, null);
                updateDialog.showSelectStatusDialog();
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
