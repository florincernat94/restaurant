package com.florincernat.restaurant.dao;

import com.florincernat.restaurant.model.Item;
import com.florincernat.restaurant.model.TableOrder;

import java.util.Optional;

public interface TableOrderDAO {
    void addOrder(TableOrder order);
    float getOrderAmount(long orderId);
    Optional<TableOrder> findById(long id);
    void addItemToOrder(Item item);
    void removeItemFromOrder(long itemId);
}
