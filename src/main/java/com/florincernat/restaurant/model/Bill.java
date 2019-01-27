package com.florincernat.restaurant.model;

import java.util.Date;

public class Bill {
    private long id;
    private long orderId;
    private float amount;
    private int discount;

    public Bill(){}

    public Bill(long orderId, float amount, int discount) {
        this.orderId = orderId;
        this.amount = amount;
        this.discount=discount;
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
