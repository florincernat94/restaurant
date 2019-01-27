package com.florincernat.restaurant.dao;

import com.florincernat.restaurant.model.Bill;

public interface BillDAO {
    void addBill(Bill bill);
    float calculateBill(long orderId, int discount);

}
