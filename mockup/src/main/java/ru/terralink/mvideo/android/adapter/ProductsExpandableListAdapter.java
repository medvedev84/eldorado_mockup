package ru.terralink.mvideo.android.adapter;

/**
 * Класс-адаптер для работы с вложенным списком товаров. Старшие элементы списка - строковые значения, вложенные элементы - товары.
 * В приложении старший список искусственно ограничен одним старшим элементом, который содержит строку "комплектация". Теоритически может содержать любое количество старших элементов.
 * @author Медведев Константин
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.terralink.mvideo.android.R;
import ru.terralink.mvideo.android.model.Order;
import ru.terralink.mvideo.android.model.Product;

public class ProductsExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    // список заказов
    private List<Order> orders;
    // множество заказ-продукты
    private Map<Order, List<Product>> ordersCollection;

    public ProductsExpandableListAdapter(Context context, List<Order> orders, HashMap<Order, List<Product>> ordersCollection) {
        this.context = context;
        this.orders = orders;
        this.ordersCollection = ordersCollection;
    }

    /**
     *  Метод возвращает количество старших элементов
     */
    @Override
    public int getGroupCount() {
        return this.orders.size();
    }

    /**
     *  Метод возвращает количество вложенных элементов для выбранного старшего элемента
     *  @param groupPosition номер старшего элемента в списке
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return this.ordersCollection.get(this.orders.get(groupPosition)).size();
    }

    /**
     *  Метод возвращает объект старшего элемента
     *  @param groupPosition номер старшего элемента в списке
     */
    @Override
    public Object getGroup(int groupPosition) {
        return this.orders.get(groupPosition);
    }

    /**
     *  Метод возвращает объект вложенного элемента
     *  @param groupPosition номер старшего элемента в списке
     *  @param childPosition номер вложенного элемента в списке
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.ordersCollection.get(this.orders.get(groupPosition)).get(childPosition);
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
        // получаем объект заказа по выбранному старшему элементу
        Order order = (Order) getGroup(groupPosition);

        if (convertView == null) {
            // получаем разметку из файла list_row_group_order_string.xml
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_row_group_order_string, null);
            // выводим сумму по заказу
            TextView txtTotal = (TextView) convertView.findViewById(R.id.total);
            txtTotal.setText(String.valueOf(order.getTotal()));
        }
        return convertView;
    }

    /**
     *  Метод возвращает представление для вложенного элемента списка.
     *  @param groupPosition номер старшего элемента в списке
     *  @param childPosition номер вложенного элемента списка
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        // получаем объект продукта по номеру выбранного старшего элемента и номеру вложенного элемента
        final Product product = (Product) getChild(groupPosition, childPosition);

        if (convertView == null) {
            // получаем разметку из файла list_row_details_order_product.xml
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_row_details_order_product, null);
        }

        //формируем представление
        TextView txtOrderId = (TextView) convertView.findViewById(R.id.productId);
        txtOrderId.setText(String.valueOf(product.getId())+". ");

        TextView txtName = (TextView) convertView.findViewById(R.id.name);
        txtName.setText(product.getName());

        TextView txtQuantity = (TextView) convertView.findViewById(R.id.quantity);
        txtQuantity.setText(String.valueOf(product.getQuantity()));

        TextView txtUnit = (TextView) convertView.findViewById(R.id.unit);
        txtUnit.setText(product.getUnit());

        TextView txtPrice = (TextView) convertView.findViewById(R.id.price);
        String price = String.valueOf(product.getPrice());
        txtPrice.setText(price);

        TextView txtCurrency = (TextView) convertView.findViewById(R.id.currency);
        txtCurrency.setText(product.getCurrency());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
