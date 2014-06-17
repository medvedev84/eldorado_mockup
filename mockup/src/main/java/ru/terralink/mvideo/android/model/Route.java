package ru.terralink.mvideo.android.model;

import java.util.ArrayList;
import java.util.List;

public class Route {

    // идентификатор маршрута (порядковый номер в приложении)
    private int id;
    // номер маршруты на сервере
    private String number;
    // номер маршрута без лидирующих нулей
    private String numberReduced;
    // номер авто
    private String vehicle;
    // имя водителя
    private String driverName;
    // имя экспедитора
    private String expeditorName;
    // дата начала (дата начала первого заказа в маршруте)
    private String strStartDate;
    // дата окончания (дата оконания последнего заказа в маршруте)
    private String strEndDate;
    // список заказов в маршруте
    private List<Order> orders = new ArrayList<Order>();

    public Route(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumberReduced() {
        return numberReduced;
    }

    public void setNumberReduced(String numberReduced) {
        this.numberReduced = numberReduced;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getExpeditorName() {
        return expeditorName;
    }

    public void setExpeditorName(String expeditorName) {
        this.expeditorName = expeditorName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getStrStartDate() {
        return strStartDate;
    }

    public void setStrStartDate(String strStartDate) {
        this.strStartDate = strStartDate;
    }

    public String getStrEndDate() {
        return strEndDate;
    }

    public void setStrEndDate(String strEndDate) {
        this.strEndDate = strEndDate;
    }

}
