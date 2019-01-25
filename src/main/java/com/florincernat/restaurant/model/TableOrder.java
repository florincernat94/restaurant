package com.florincernat.restaurant.model;

import java.util.Date;

public class TableOrder {
    private long id;
    private long tableId;
    private Date orderDate;

    public TableOrder(){}

    public TableOrder(long tableId) {
        this.tableId = tableId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
