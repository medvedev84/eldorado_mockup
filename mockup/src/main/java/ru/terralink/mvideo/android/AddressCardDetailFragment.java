package ru.terralink.mvideo.android;
/**
 * Fragment для показа карточки заказа
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ru.terralink.mvideo.android.adapter.ProductsExpandableListAdapter;
import ru.terralink.mvideo.android.data.DataStorage;
import ru.terralink.mvideo.android.model.Order;
import ru.terralink.mvideo.android.model.OrderStatus;
import ru.terralink.mvideo.android.model.Product;

public class AddressCardDetailFragment extends Fragment {

    // заказ
    private Order order;
    // список заказов из одного элемента (такая иммитация нужна для элемента ExpandableListView, который работает только со списками)
    private List<Order> orders;
    // список продуктов для одного заказа
    private HashMap<Order, List<Product>> ordersCollection;

    public AddressCardDetailFragment() {
        // Любой фрагмент должен иметь пустой конструктор по умолчанию
    }

    public AddressCardDetailFragment(Order order) {
        this.order = order;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_address_card_detail, container, false);

        TextView syncDateTextView = (TextView) rootView.findViewById(R.id.syncDate);
        if (syncDateTextView != null)
            syncDateTextView.setText(new SimpleDateFormat("dd.MM.yyyy").format(DataStorage.getSelectedDate()));

        // подготавливаем данные для карточки
        prepareData();

        // отображаем данные заказа в соответствующих элементах формы
        TextView orderNumberTextView = (TextView) rootView.findViewById(R.id.orderNumber);
        orderNumberTextView.setText("№" + order.getOrderNumberReduced());
        TextView deadlineTextView = (TextView) rootView.findViewById(R.id.deadline);
        deadlineTextView.setText("с " + order.getStrStartDate() + " до " + order.getStrEndDate());
        TextView addressTextView = (TextView) rootView.findViewById(R.id.address);
        addressTextView.setText(order.getAddress());

        TextView fioTextView = (TextView) rootView.findViewById(R.id.fio);
        fioTextView.setText(order.getFio());
        TextView phone1TextView = (TextView) rootView.findViewById(R.id.phone1);
        phone1TextView.setText(order.getPhone1());
        phone1TextView.setVisibility(order.getPhone1() != null && !order.getPhone1().equals("") ? View.VISIBLE: View.GONE);
        TextView phone2TextView = (TextView) rootView.findViewById(R.id.phone2);
        phone2TextView.setText(order.getPhone2());
        phone1TextView.setVisibility(order.getPhone2() != null && !order.getPhone2().equals("") ? View.VISIBLE: View.GONE);

        final TextView notesTextView = (TextView) rootView.findViewById(R.id.notes);
        notesTextView.setText("\n" + order.getComment());
        final TextView statusTextView = (TextView) rootView.findViewById(R.id.status);
        statusTextView.setText(order.getStatus().getName());
        statusTextView.setTextColor(order.getStatus().getColor());

        final TextView delayTextView = (TextView) rootView.findViewById(R.id.status_comment);
        delayTextView.setTextColor(order.getStatus().getColor());
        if (order.getStatus() == OrderStatus.Z_DELAY) {
            delayTextView.setText(DataStorage.getDelayedOrders().get(order.getOrderNumber()).getStrDelay());
        }

        // обработчик смены статуса заказа
        statusTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusTextView.setEnabled(false);
                UpdateStatusDialog updateDialog = new UpdateStatusDialog(getActivity(), order, statusTextView, delayTextView, notesTextView);
                updateDialog.showSelectStatusDialog();
            }
        });

        // выпадающий список с продуктами по заказу
        final ExpandableListView expListView = (ExpandableListView) rootView.findViewById(R.id.product_list);
        expListView.setAdapter(
                new ProductsExpandableListAdapter(
                        getActivity(),
                        orders,
                        ordersCollection
                )
        );
        // принудительно раскрываем список
        expListView.expandGroup(0);
        return rootView;
    }

    /**
     * Метод подготовки данных для карточки заказа
     * Задает выпадающий список продуктов только для одного заказа
     */
    private void prepareData() {
        orders = new ArrayList<Order>();
        ordersCollection = new HashMap<Order, List<Product>>();
        orders.add(order);
        List<Product> products = order.getProducts();
        ordersCollection.put(orders.get(0), products);
    }

}
