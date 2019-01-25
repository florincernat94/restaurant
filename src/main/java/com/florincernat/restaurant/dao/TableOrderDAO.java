package com.florincernat.restaurant.dao;

import com.florincernat.restaurant.model.TableOrder;

import java.util.Optional;

public interface TableOrderDAO {
    void addOrder(TableOrder order);
    Optional<Float> getOrderAmount(long orderId);
    Optional<TableOrder> findById(Long id);
}
