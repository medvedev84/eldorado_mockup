package ru.terralink.mvideo.android.model;

/**
 * Класс-модель для объекта продукт
 * @author Медведев Константин
 */

import java.math.BigDecimal;

public class Product {

    // идентификатор заказа (порядковый номер внутри заказа)
    private int id;
    // имя продукта
    private String name;
    // цена за единицу
    private BigDecimal price;
    // строковое обозначение валюты
    private String currency;
    // количество
    private BigDecimal quantity;
    // тип измерения единицы товара
    private String unit;

    public Product() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
