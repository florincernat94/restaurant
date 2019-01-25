package com.florincernat.restaurant.model;

import java.util.Date;

public class Bill {
    private long id;
    private long orderId;
    private float price;
    private Date date;

    public Bill(){}

    public Bill(long orderId, float price, Date date) {
        this.orderId = orderId;
        this.price = price;
        this.date=date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
