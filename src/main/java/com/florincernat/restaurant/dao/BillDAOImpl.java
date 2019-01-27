package com.florincernat.restaurant.dao;

import com.florincernat.restaurant.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BillDAOImpl implements BillDAO {
    private final static String ADD_BILL_QUERY = "insert into bill (generate_id('bill')," +
            "order_id,amount,discount) values (:id,:order_id,:amount,:discount)";

    @Autowired
    NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public void addBill(Bill bill) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("order_id", bill.getOrderId());
        paramMap.put("amount", bill.getAmount());
        paramMap.put("discount", bill.getDiscount());
        namedJdbcTemplate.update(ADD_BILL_QUERY, paramMap);
    }

    @Override
    public float calculateBill(long orderId, int discount) {
        return 0;
    }
}
