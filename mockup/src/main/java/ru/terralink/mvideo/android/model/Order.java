package ru.terralink.mvideo.android.model;

/**
 * Класс-модель для объекта заказ
 * @author Медведев Константин
 */

import com.google.android.gms.maps.model.LatLng;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Order {

    // идентификатор заказа (порядковый номер в приложении)
    private int id;
    // адрес заказа для отображения
    private String address;
    // адрес заказа для поиска координат в Google Map
    private String addressForSearch;
    // статус заказа
    private OrderStatus status;
    // ФИО получается
    private String fio;
    // телефон получатея
    private String phone1;
    // телефон получатея
    private String phone2;
    // номер заказа на сервере
    private String orderNumber;
    // номер заказа без лидирующих нулей
    private String orderNumberReduced;
    // номер маршрута на сервере
    private String routeNumber;
    // номер маршрута без лидирующих нулей
    private String routeNumberReduced;
    // точка адреса (широта, долгота)
    private LatLng point;
    // комментарий к заказу
    private String comment;
    // время начала доставки
    private Time startDate;
    // время конца доставки
    private Time endDate;
    // время начала доставки - строковое представление
    private String strStartDate;
    // время конца доставки - строковое представление
    private String strEndDate;
    // идентификатор статуса
    private int statusId;
    // строковое отображение статуса
    private String statusName;
    // время задержки в секундах
    private int delay;
    // строковое отображение задержки
    private String strDelay;
    // общая стоимость заказа
    private BigDecimal total;

    private List<Product> products = new ArrayList<Product>();

    public Order(){}

    public Order(String address, OrderStatus status) {
        this.address = address;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressForSearch() {
        return addressForSearch;
    }

    public void setAddressForSearch(String addressForSearch) {
        this.addressForSearch = addressForSearch;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public LatLng getPoint() {
        return point;
    }

    public void setPoint(LatLng point) {
        this.point = point;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Time getEndDate() {
        return endDate;
    }

    public void setEndDate(Time endDate) {
        this.endDate = endDate;
    }

    public Time getStartDate() {
        return startDate;
    }

    public void setStartDate(Time startDate) {
        this.startDate = startDate;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public String getOrderNumberReduced() {
        return orderNumberReduced;
    }

    public void setOrderNumberReduced(String orderNumberReduced) {
        this.orderNumberReduced = orderNumberReduced;
    }

    public String getRouteNumberReduced() {
        return routeNumberReduced;
    }

    public void setRouteNumberReduced(String routeNumberReduced) {
        this.routeNumberReduced = routeNumberReduced;
    }

    public String getStrDelay() {
        return strDelay;
    }

    public void setStrDelay(String strDelay) {
        this.strDelay = strDelay;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }
}
