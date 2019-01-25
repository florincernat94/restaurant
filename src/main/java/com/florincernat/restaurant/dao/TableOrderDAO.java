package com.florincernat.restaurant.dao;

import com.florincernat.restaurant.model.TableOrder;

public interface TableOrderDAO {
    void addOrder(TableOrder order);
    float getOrderAmount(long orderId);
}
