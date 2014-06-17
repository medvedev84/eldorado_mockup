package ru.terralink.mvideo.android.data;

/**
 * Класс-помощник для хранения глобальных данных в памяти приложения
 * @author Медведев Константин
 */

import android.content.Context;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.sybase.collections.GenericList;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import ru.terralink.mvideo.android.db.DatabaseHelper;
import ru.terralink.mvideo.android.model.Order;
import ru.terralink.mvideo.android.model.OrderStatus;
import ru.terralink.mvideo.android.model.Product;
import ru.terralink.mvideo.android.model.Route;
import ru.terralink.mvideo.sap.OperDay;
import ru.terralink.mvideo.sap.Orders;
import ru.terralink.mvideo.sap.Products;
import ru.terralink.mvideo.sap.Relations;


public class DataStorage {
    private static String APP = "mvideo4";

    // массив статусов
    private static OrderStatus[] statuses = new OrderStatus[] {
            OrderStatus.Z_DLV_PART,
            OrderStatus.LOAD_END,
            OrderStatus.POD,
            OrderStatus.Z_DELAY,
            OrderStatus.Z_RETURNS,
            OrderStatus.Z_U_FM
    };

    // выбранная дата
    private static Date selectedDate;
    // номер авто
    private static String vehicleNumber;
    // список маршрутов
    private static List<Route> routes = new ArrayList<Route>();
    // список "просроченных" заказов (заказов со статусом "задержка")
    private static HashMap<String, Order> delayedOrders = new HashMap<String, Order>();
    // метод доступа для массива статусов
    public static OrderStatus[] getStatuses() {
        return statuses;
    }
    // метод доступа для массива названий статусов
    public static String[] getStatusNames(){
        return new String[] {"Доставлено частично", "Погрузка окончена", "Доставлено", "Задержка доставки", "Возвращено", "Не доставлено"};
    }

    public static Date getSelectedDate() {
        return selectedDate;
    }

    public static void setSelectedDate(Date selectedDate) {
        DataStorage.selectedDate = selectedDate;
    }

    public static String getVehicleNumber() {
        return vehicleNumber;
    }

    public static void setVehicleNumber(String vehicleNumber) {
        DataStorage.vehicleNumber = vehicleNumber;
    }

    public static List<Route> getRoutes() {
        return routes;
    }

    public static HashMap<String, Order> getDelayedOrders() {
        return delayedOrders;
    }

    public static GenericList<OperDay> getByIvDateAndIvNumber(Date syncDate, String vehicleNumber){
        GenericList<OperDay> operDays = new GenericList<OperDay>();

        OperDay operDay = new OperDay();
        operDay.setTOR_ID("000000100001");
        operDay.setIV_VEHICLE_NUMB("A777AA01");
        operDay.setZDRIVER_NAME("Иванов А.");
        operDay.setZNAME_ORG1("Петров");
        operDay.setZNAME_ORG2("Петр");
        GenericList<Relations> relations = new GenericList<Relations>();
        Relations relation = new Relations();
        relation.setRelationsOrderss(getOrders());
        relations.add(relation);
        operDay.setOperDayRelations(relations);
        operDays.add(operDay);

        operDay = new OperDay();
        operDay.setTOR_ID("000000100002");
        operDay.setIV_VEHICLE_NUMB("A777AA01");
        operDay.setZDRIVER_NAME("Ионов В.");
        operDay.setZNAME_ORG1("Екименко");
        operDay.setZNAME_ORG2("Максим");
        relations = new GenericList<Relations>();
        relation = new Relations();
        relation.setRelationsOrderss(getOrders2());
        relations.add(relation);
        operDay.setOperDayRelations(relations);
        operDays.add(operDay);

        return operDays;
    }

    private static GenericList<Orders> getOrders() {
        GenericList<Orders> orders = new GenericList<Orders>();

        Orders fu = new Orders();
        fu.setCITY1("Москва");
        fu.setPOST_CODE1("121115");
        fu.setSTREET("Ломоносовский проспект");
        fu.setHOUSE_NUM1("45");
        fu.setNAME1("Иванов");
        fu.setNAME2("Иван");
        fu.setNAME3("Иванович");
        fu.setTEL_NUMBER("+7(495)729-19-93");
        fu.setIV_FU_TOR_ID("000000100001");
        fu.setIV_FO_TOR_ID("000000100001");
        fu.setREQ_START_TIME(new Time(1400824800000l));
        fu.setREQ_END_TIME(new Time(1400850000000l));
        fu.setEVENT_CODE("LOAD_END");
        fu.setEXECUTION("1");
        fu.setDDTEXT("-");
        fu.setOrdersProductss(getProducts());
        orders.add(fu);

        fu = new Orders();
        fu.setCITY1("Москва");
        fu.setPOST_CODE1("121115");
        fu.setSTREET("Ленинский проспект");
        fu.setHOUSE_NUM1("88");
        fu.setNAME1("Широков");
        fu.setNAME2("Иван");
        fu.setNAME3("Иванович");
        fu.setTEL_NUMBER("+7(495)235-19-15");
        fu.setIV_FU_TOR_ID("000000100002");
        fu.setIV_FO_TOR_ID("000000100001");
        fu.setREQ_START_TIME(new Time(1400824800000l));
        fu.setREQ_END_TIME(new Time(1400850000000l));
        fu.setEVENT_CODE("LOAD_END");
        fu.setEXECUTION("1");
        fu.setDDTEXT("-");
        fu.setOrdersProductss(getProducts());
        orders.add(fu);

        fu = new Orders();
        fu.setCITY1("Москва");
        fu.setPOST_CODE1("121115");
        fu.setSTREET("Дмитрия Ульянова улица");
        fu.setHOUSE_NUM1("32");
        fu.setNAME1("Максимов");
        fu.setNAME2("Анатолий");
        fu.setNAME3("Иванович");
        fu.setTEL_NUMBER("+7(495)729-28-93");
        fu.setIV_FU_TOR_ID("000000100003");
        fu.setIV_FO_TOR_ID("000000100001");
        fu.setREQ_START_TIME(new Time(1400824800000l));
        fu.setREQ_END_TIME(new Time(1400850000000l));
        fu.setEVENT_CODE("LOAD_END");
        fu.setEXECUTION("1");
        fu.setDDTEXT("-");
        fu.setOrdersProductss(getProducts());
        orders.add(fu);

        fu = new Orders();
        fu.setCITY1("Москва");
        fu.setPOST_CODE1("121115");
        fu.setSTREET("Вавилова улица");
        fu.setHOUSE_NUM1("69");
        fu.setNAME1("Юминова");
        fu.setNAME2("Иван");
        fu.setNAME3("Сергеевич");
        fu.setTEL_NUMBER("+7(495)729-19-77");
        fu.setIV_FU_TOR_ID("000000100004");
        fu.setIV_FO_TOR_ID("000000100001");
        fu.setREQ_START_TIME(new Time(1400824800000l));
        fu.setREQ_END_TIME(new Time(1400850000000l));
        fu.setEVENT_CODE("LOAD_END");
        fu.setEXECUTION("1");
        fu.setDDTEXT("-");
        fu.setOrdersProductss(getProducts());
        orders.add(fu);

        fu = new Orders();
        fu.setCITY1("Москва");
        fu.setPOST_CODE1("121115");
        fu.setSTREET("Ивана Бабушкина улица");
        fu.setHOUSE_NUM1("20");
        fu.setNAME1("Еременко");
        fu.setNAME2("Станислав");
        fu.setNAME3("Петрович");
        fu.setTEL_NUMBER("+7(495)729-19-93");
        fu.setIV_FU_TOR_ID("000000100005");
        fu.setIV_FO_TOR_ID("000000100001");
        fu.setREQ_START_TIME(new Time(1400824800000l));
        fu.setREQ_END_TIME(new Time(1400850000000l));
        fu.setEVENT_CODE("LOAD_END");
        fu.setEXECUTION("1");
        fu.setDDTEXT("-");
        fu.setOrdersProductss(getProducts());
        orders.add(fu);

        fu = new Orders();
        fu.setCITY1("Москва");
        fu.setPOST_CODE1("121115");
        fu.setSTREET("Южнобутовская улица");
        fu.setHOUSE_NUM1("117");
        fu.setNAME1("Петренко");
        fu.setNAME2("Максим");
        fu.setNAME3("Ибрагимович");
        fu.setTEL_NUMBER("+7(495)223-56-93");
        fu.setIV_FU_TOR_ID("000000100006");
        fu.setIV_FO_TOR_ID("000000100001");
        fu.setREQ_START_TIME(new Time(1400824800000l));
        fu.setREQ_END_TIME(new Time(1400850000000l));
        fu.setEVENT_CODE("LOAD_END");
        fu.setEXECUTION("1");
        fu.setDDTEXT("-");
        fu.setOrdersProductss(getProducts());
        orders.add(fu);

        return orders;
    }

    private static GenericList<Orders> getOrders2() {
        GenericList<Orders> orders = new GenericList<Orders>();

        Orders fu = new Orders();
        fu.setCITY1("Москва");
        fu.setPOST_CODE1("121115");
        fu.setSTREET("Волгоградский проспект");
        fu.setHOUSE_NUM1("54");
        fu.setNAME1("Прохоров");
        fu.setNAME2("Василий");
        fu.setNAME3("Иванович");
        fu.setTEL_NUMBER("+7(495)705-19-93");
        fu.setIV_FU_TOR_ID("000000200001");
        fu.setIV_FO_TOR_ID("000000100002");
        fu.setREQ_START_TIME(new Time(1401368400000l));
        fu.setREQ_END_TIME(new Time(1401393540000l));
        fu.setEVENT_CODE("LOAD_END");
        fu.setEXECUTION("1");
        fu.setDDTEXT("-");
        fu.setOrdersProductss(getProducts());
        orders.add(fu);

        fu = new Orders();
        fu.setCITY1("Москва");
        fu.setPOST_CODE1("121115");
        fu.setSTREET("Трифоновская улица");
        fu.setHOUSE_NUM1("15");
        fu.setNAME1("Широков");
        fu.setNAME2("Иван");
        fu.setNAME3("Иванович");
        fu.setTEL_NUMBER("+7(495)235-19-15");
        fu.setIV_FU_TOR_ID("000000200002");
        fu.setIV_FO_TOR_ID("000000100002");
        fu.setREQ_START_TIME(new Time(1401368400000l));
        fu.setREQ_END_TIME(new Time(1401393540000l));
        fu.setEVENT_CODE("LOAD_END");
        fu.setEXECUTION("1");
        fu.setDDTEXT("-");
        fu.setOrdersProductss(getProducts());
        orders.add(fu);

        fu = new Orders();
        fu.setCITY1("Москва");
        fu.setPOST_CODE1("121115");
        fu.setSTREET(" 2-я Вольская улица");
        fu.setHOUSE_NUM1("11");
        fu.setNAME1("Максимов");
        fu.setNAME2("Анатолий");
        fu.setNAME3("Иванович");
        fu.setTEL_NUMBER("+7(495)729-28-93");
        fu.setIV_FU_TOR_ID("000000200003");
        fu.setIV_FO_TOR_ID("000000100002");
        fu.setREQ_START_TIME(new Time(1401368400000l));
        fu.setREQ_END_TIME(new Time(1401393540000l));
        fu.setEVENT_CODE("LOAD_END");
        fu.setEXECUTION("1");
        fu.setDDTEXT("-");
        fu.setOrdersProductss(getProducts());
        orders.add(fu);

        fu = new Orders();
        fu.setCITY1("Москва");
        fu.setPOST_CODE1("121115");
        fu.setSTREET("проспект Революции");
        fu.setHOUSE_NUM1("6");
        fu.setNAME1("Юминова");
        fu.setNAME2("Алла");
        fu.setNAME3("Борисовна");
        fu.setTEL_NUMBER("+7(495)729-19-77");
        fu.setIV_FU_TOR_ID("000000200004");
        fu.setIV_FO_TOR_ID("000000100002");
        fu.setREQ_START_TIME(new Time(1401368400000l));
        fu.setREQ_END_TIME(new Time(1401393540000l));
        fu.setEVENT_CODE("LOAD_END");
        fu.setEXECUTION("1");
        fu.setDDTEXT("-");
        fu.setOrdersProductss(getProducts());
        orders.add(fu);

        fu = new Orders();
        fu.setCITY1("Москва");
        fu.setPOST_CODE1("121115");
        fu.setSTREET("Красноказарменная улица");
        fu.setHOUSE_NUM1("13");
        fu.setNAME1("Еременко");
        fu.setNAME2("Станислав");
        fu.setNAME3("Петрович");
        fu.setTEL_NUMBER("+7(495)729-19-93");
        fu.setIV_FU_TOR_ID("000000200005");
        fu.setIV_FO_TOR_ID("000000100002");
        fu.setREQ_START_TIME(new Time(1401368400000l));
        fu.setREQ_END_TIME(new Time(1401393540000l));
        fu.setEVENT_CODE("LOAD_END");
        fu.setEXECUTION("1");
        fu.setDDTEXT("-");
        fu.setOrdersProductss(getProducts());
        orders.add(fu);

        fu = new Orders();
        fu.setCITY1("Москва");
        fu.setPOST_CODE1("121115");
        fu.setSTREET("Крылатская улица");
        fu.setHOUSE_NUM1("10");
        fu.setNAME1("Петренко");
        fu.setNAME2("Максим");
        fu.setNAME3("Ибрагимович");
        fu.setTEL_NUMBER("+7(495)223-56-93");
        fu.setIV_FU_TOR_ID("000000200006");
        fu.setIV_FO_TOR_ID("000000100002");
        fu.setREQ_START_TIME(new Time(1401368400000l));
        fu.setREQ_END_TIME(new Time(1401393540000l));
        fu.setEVENT_CODE("LOAD_END");
        fu.setEXECUTION("1");
        fu.setDDTEXT("-");
        fu.setOrdersProductss(getProducts());
        orders.add(fu);

        return orders;
    }

    private static GenericList<Products> getProducts(){
        GenericList<Products> products = new GenericList<Products>();

        Products product = new Products();
        product.setITEM_DESCR("Телевизор LG 102");
        product.setAMT_GDSV_VAL(new BigDecimal(9990));
        product.setAMT_GDSV_CUR("руб.");
        product.setQUA_PCS_VAL(BigDecimal.ONE);
        product.setQUA_PCS_UNI("шт.");
        products.add(product);

        product = new Products();
        product.setITEM_DESCR("DVD-плеер LG");
        product.setAMT_GDSV_VAL(new BigDecimal(2990));
        product.setAMT_GDSV_CUR("руб.");
        product.setQUA_PCS_VAL(BigDecimal.ONE);
        product.setQUA_PCS_UNI("шт.");
        products.add(product);

        product = new Products();
        product.setITEM_DESCR("Магнитола SONY");
        product.setAMT_GDSV_VAL(new BigDecimal(5990));
        product.setAMT_GDSV_CUR("руб.");
        product.setQUA_PCS_VAL(BigDecimal.ONE);
        product.setQUA_PCS_UNI("шт.");
        products.add(product);

        product = new Products();
        product.setITEM_DESCR("Пылесос Bosh");
        product.setAMT_GDSV_VAL(new BigDecimal(2390));
        product.setAMT_GDSV_CUR("руб.");
        product.setQUA_PCS_VAL(BigDecimal.ONE);
        product.setQUA_PCS_UNI("шт.");
        products.add(product);

        product = new Products();
        product.setITEM_DESCR("Газовая плита Ariston");
        product.setAMT_GDSV_VAL(new BigDecimal(7990));
        product.setAMT_GDSV_CUR("руб.");
        product.setQUA_PCS_VAL(BigDecimal.ONE);
        product.setQUA_PCS_UNI("шт.");
        products.add(product);

        return products;
    }

    public static void resetData(){
        getDelayedOrders().clear();
        for (Order order : routes.get(0).getOrders()){
            order.setStatus(OrderStatus.LOAD_END);
        }
    }

    /**
     *  Метод загрузки данных с сервера и сохранения в памяти приложения
     *  @param context контекст приложения
     */
    public static void loadData(Context context){
        routes.clear();

        // преобразуем дату в формат java.sql.Date
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = sm.format(DataStorage.getSelectedDate());
        java.sql.Date syncDate = java.sql.Date.valueOf(strDate);

        // вызываем метод SUP, который возвращает опер дни по дате и номеру авто
        //GenericList<OperDay> orders = OperDay.getByIvDateAndIvNumber(syncDate, DataStorage.getVehicleNumber());
        GenericList<OperDay> orders = getByIvDateAndIvNumber(syncDate, DataStorage.getVehicleNumber());

        // создаем класс-помощник для работы с локальной БД
        DatabaseHelper db = new DatabaseHelper(context);

        int k = 0;
        for (OperDay operDay : orders) {
            // перекладываем данные из сущности "операционный день" в класс-модель "маршрут"
            String routeNumber = operDay.getTOR_ID();
            Route route = new Route(routeNumber);
            route.setId(++k);
            route.setNumberReduced(routeNumber.replaceFirst("0*",""));
            route.setVehicle(operDay.getIV_VEHICLE_NUMB());
            route.setDriverName(operDay.getZDRIVER_NAME());
            route.setExpeditorName(operDay.getZNAME_ORG1() + " " + operDay.getZNAME_ORG2());
            routes.add(route);

            int i = 0;

            // получает классы Relations, которые хранят в себе заказы
            for (Relations relation : operDay.getOperDayRelations()) {
                com.sybase.collections.GenericList<ru.terralink.mvideo.sap.Orders> orderss = relation.getRelationsOrderss();
                for (Orders fu : orderss) {
                    if (fu != null) {
                        // перекладываем данные из сущности "заказы" в класс-модель "заказ"
                        Order order = new Order();
                        order.setId(++i);

                        String city = fu.getCITY1() != null ? fu.getCITY1() : "";
                        String post = fu.getPOST_CODE1() != null ? fu.getPOST_CODE1() : "";
                        String street = fu.getSTREET() != null ? fu.getSTREET() : "";
                        String house1 = fu.getHOUSE_NUM1() != null ? fu.getHOUSE_NUM1() : "";

                        String address =  city + ", " + street + ", " + house1;
                        String house2 = fu.getHOUSE_NUM2() != null ? fu.getHOUSE_NUM2() : "";
                        if (!house2.equals(""))
                            address = address +  ", " + house2;

                        String building = fu.getBUILDING() != null ? fu.getBUILDING() : "";
                        if (!building.equals(""))
                            address = address +  ", " + building;

                        String floor = fu.getFLOOR() != null ? fu.getFLOOR() : "";
                        if (!floor.equals(""))
                            address = address +  ", " + floor;

                        String room = fu.getROOMNUMBER() != null ? fu.getROOMNUMBER() : "";
                        if (!room.equals(""))
                            address = address +  ", " + room;

                        order.setAddress(address);
                        order.setAddressForSearch(
                                house1 + " " + house2 + " " + building + " " + floor + " " + room + ", " +
                                        street + ", " +
                                        post + ", " +
                                        city
                        );

                        String fio = fu.getNAME1();
                        if (fu.getNAME2() != null && !fu.getNAME2().equals(""))
                            fio = fio + " " + fu.getNAME2();
                        if (fu.getNAME3() != null && !fu.getNAME3().equals(""))
                            fio = fio + " " + fu.getNAME3();
                        if (fu.getNAME4() != null && !fu.getNAME4().equals(""))
                            fio = fio + " " + fu.getNAME4();

                        order.setFio(fio);
                        order.setPhone1(fu.getTEL_NUMBER());
                        order.setPhone2(fu.getZTEL_NUMBER2());

                        String orderNumber = fu.getIV_FU_TOR_ID();
                        order.setOrderNumber(orderNumber);
                        order.setOrderNumberReduced(orderNumber.replaceFirst("0*",""));

                        routeNumber = fu.getIV_FO_TOR_ID();
                        order.setRouteNumber(routeNumber);
                        order.setRouteNumberReduced(routeNumber.replaceFirst("0*",""));

                        order.setPoint( new LatLng(fu.getYPOS(), fu.getXPOS()));

                        order.setStartDate(fu.getREQ_START_TIME());
                        order.setEndDate(fu.getREQ_END_TIME());
                        String strStartDate = fu.getREQ_START_TIME().toString();
                        String strEndDate = fu.getREQ_END_TIME().toString();

                        // преобразуем время в формат чч:мм:сс
                        try {
                            Date date = new SimpleDateFormat("HH:mm:ss").parse(strStartDate);
                            String newDate = new SimpleDateFormat("H:mm").format(date);
                            order.setStrStartDate(newDate);

                            date = new SimpleDateFormat("HH:mm:ss").parse(strEndDate);
                            newDate = new SimpleDateFormat("H:mm").format(date);
                            order.setStrEndDate(newDate);

                        } catch (ParseException e) {
                            order.setStrStartDate(strStartDate);
                            order.setStrEndDate(strEndDate);
                            Log.e(APP, "Can not convert " + strStartDate + " or " + strEndDate + " to HH:mm:ss");
                            e.printStackTrace();
                        }

                        order.setStatusId(Integer.valueOf(fu.getEXECUTION()));
                        order.setStatusName(fu.getDDTEXT());

                        // через набор проверок сохраняем статус заказа по его строковому коду
                        if (fu.getEVENT_CODE().equals(OrderStatus.LOAD_END.getCode())) {
                            order.setStatus(OrderStatus.LOAD_END);
                        } else if (fu.getEVENT_CODE().equals(OrderStatus.Z_DELAY.getCode())) {
                            order.setStatus(OrderStatus.Z_DELAY);

                            Order delayedOrder;
                            // если заказ имет статус "задержка", то проверяем, хранится ли он уже в нашей БД
                            if (db.isExists(order.getOrderNumber())) {
                                // если хранится, то извлекаем данные по нему из БД
                                delayedOrder = db.getOrder(order.getOrderNumber());
                            } else {
                                // если его нет в БД, то сохраняем
                                delayedOrder = new Order();
                                delayedOrder.setOrderNumber(order.getOrderNumber());
                                delayedOrder.setDelay(0);
                                delayedOrder.setStrDelay("");
                                db.createOrder(delayedOrder);
                            }

                            // обновляем коллекцию "просроченных" заказов в памяти приложения
                            getDelayedOrders().remove(delayedOrder.getOrderNumber());
                            getDelayedOrders().put(delayedOrder.getOrderNumber(), delayedOrder);

                        } else if (fu.getEVENT_CODE().equals(OrderStatus.Z_RETURNS.getCode())) {
                            order.setStatus(OrderStatus.Z_RETURNS);
                        } else if (fu.getEVENT_CODE().equals(OrderStatus.POD.getCode())) {
                            order.setStatus(OrderStatus.POD);
                        } else if (fu.getEVENT_CODE().equals(OrderStatus.Z_DLV_PART.getCode())) {
                            order.setStatus(OrderStatus.Z_DLV_PART);
                        } else if (fu.getEVENT_CODE().equals(OrderStatus.Z_U_FM.getCode())) {
                            order.setStatus(OrderStatus.Z_U_FM);
                        } else {
                            // by default set to LOAD_END
                            order.setStatus(OrderStatus.LOAD_END);
                        }

                        order.setComment(fu.getZCOMMENTS());

                        GenericList<Products> productss = fu.getOrdersProductss();
                        BigDecimal totalOrder = BigDecimal.ZERO;
                        int j = 0;
                        // извлекаем продукты заказа
                        for (Products products : productss) {
                            Product product = new Product();
                            product.setId(++j);
                            product.setName(products.getITEM_DESCR());
                            product.setPrice(products.getAMT_GDSV_VAL());
                            product.setCurrency(products.getAMT_GDSV_CUR());
                            product.setQuantity(products.getQUA_PCS_VAL());
                            product.setUnit(products.getQUA_PCS_UNI());
                            order.getProducts().add(product);
                            totalOrder = totalOrder.add(product.getPrice());
                        }
                        // сохраняем общую сумму по заказу
                        order.setTotal(totalOrder);

                        route.getOrders().add(order);
                        if (i == 1) {
                            // сохраняем время начала первого заказа как время начала маршрута
                            route.setStrStartDate(order.getStrStartDate());
                        }
                        // сохраняем время конца последнего заказа как время конца маршрута
                        route.setStrEndDate(order.getStrEndDate());
                    }
                }
            }
        }
        // завершаем работу с БД
        db.closeDB();
    }

}
