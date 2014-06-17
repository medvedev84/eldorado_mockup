package ru.terralink.mvideo.android.model;

/**
 * Класс-перечисление для статуса заказа
 * @author Медведев Константин
 */

import android.graphics.Color;

public enum OrderStatus {
    Z_DLV_PART("Z_DLV_PART", "Доставлено частично", Color.RED),
    LOAD_END("LOAD_END","Погрузка окончена", Color.BLACK),
    POD("POD", "Доставлено", Color.GREEN),
    Z_DELAY("Z_DELAY", "Задержка доставки", Color.YELLOW),
    Z_RETURNS("Z_RETURNS", "Возвращено", Color.BLACK),
    Z_U_FM("Z_U_FM", "Не доставлено", Color.RED);

    // код статуса
    private String code;
    // название статуса
    private String name;
    // цвет статуса
    private int color;

    OrderStatus(String code, String name, int color) {
        this.name = name;
        this.code = code;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getColor() {
        return color;
    }
}
