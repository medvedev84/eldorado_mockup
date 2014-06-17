package ru.terralink.mvideo.android.db;

/**
 * Класс-помощник для работы с БД. Используется для хранения "просроченных" заказов, т.е. заказов со статусом "задержка"
 * @author Медведев Константин
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import ru.terralink.mvideo.android.model.Order;

public class DatabaseHelper extends SQLiteOpenHelper {

    // тэг для логгера
    private static final String LOG = "DatabaseHelper";

    // версия БД
    private static final int DATABASE_VERSION = 1;

    // имя БД
    private static final String DATABASE_NAME = "mvideo";

    // имя таблицы
    private static final String TABLE_DELAYED_ORDER = "delayed_orders";

    // имена колонок
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";
    private static final String KEY_NUMBER = "number";
    private static final String KEY_DELAY = "delay";
    private static final String KEY_DELAY_DESCRIPTION = "delay_description";

    // sql-запрос на создание страниц
    private static final String CREATE_TABLE_DELAYED_ORDER = "CREATE TABLE "
            + TABLE_DELAYED_ORDER + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NUMBER + " TEXT,"
            + KEY_DELAY + " INTEGER,"
            + KEY_DELAY_DESCRIPTION + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_DELAYED_ORDER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DELAYED_ORDER);

        // создаем БД
        onCreate(db);
    }

    /**
     *  Метод создания заказа
     *  @param order заказ
     */
    public long createOrder(Order order) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NUMBER, order.getOrderNumber());
        values.put(KEY_DELAY, order.getDelay());
        values.put(KEY_DELAY_DESCRIPTION, order.getStrDelay());

        long order_id = db.insert(TABLE_DELAYED_ORDER, null, values);
        return order_id;
    }

    /**
     *  Метод проверки существования заказа с определенным номером
     *  @param orderNumber номер заказа
     */
    public boolean isExists(String orderNumber) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_DELAYED_ORDER + " WHERE " + KEY_NUMBER + " = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[] { orderNumber });
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }

    /**
     *  Метод возвращает заказ по номеру
     *  @param orderNumber номер заказа
     */
    public Order getOrder(String orderNumber) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_DELAYED_ORDER + " WHERE " + KEY_NUMBER + " = ?";
        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, new String[] { orderNumber });
        if (c != null)
            c.moveToFirst();

        Order order = new Order();
        order.setDelay(c.getInt(c.getColumnIndex(KEY_DELAY)));
        order.setOrderNumber(c.getString(c.getColumnIndex(KEY_NUMBER)));
        order.setStrDelay (c.getString(c.getColumnIndex(KEY_DELAY_DESCRIPTION)));
        return order;
    }

    /**
     *  Метод обновления заказа
     *  @param order заказ
     */
    public int updateOrder(Order order) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_DELAY, order.getDelay());
        values.put(KEY_DELAY_DESCRIPTION, order.getStrDelay());

        return db.update(TABLE_DELAYED_ORDER, values, KEY_NUMBER + " = ?", new String[] { order.getOrderNumber() });
    }

    /**
     *  Метод удаления заказа
     *  @param order заказ
     */
    public void deleteOrder(Order order) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DELAYED_ORDER, KEY_NUMBER + " = ?", new String[] { order.getOrderNumber() });
    }

    /**
     *  Метод закрывает соединение с БД
     */
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
