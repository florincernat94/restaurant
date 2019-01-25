package com.florincernat.restaurant.model;

import java.util.Date;

public class TableOrder {
    private long id;
    private long tableId;
    private Date orerDate;

    public TableOrder(){}

    public TableOrder(long id, long tableId, Date orerDate) {
        this.id = id;
        this.tableId = tableId;
        this.orerDate = orerDate;
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

    public Date getOrerDate() {
        return orerDate;
    }

    public void setOrerDate(Date orerDate) {
        this.orerDate = orerDate;
    }
}
