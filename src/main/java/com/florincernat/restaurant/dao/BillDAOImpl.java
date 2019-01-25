package com.florincernat.restaurant.dao;

import com.florincernat.restaurant.model.Bill;
import org.springframework.stereotype.Repository;

@Repository
public class BillDAOImpl implements BillDAO{
    private final static String ADD_BILL_QUERY= "insert into bill (id,order_id,price,date) values (:id,:order_id,:price,:date";

    @Override
    public void addBill(Bill bill) {

    }

    @Override
    public float calculateBill(Long orderId) {
        return 0;
    }
}
