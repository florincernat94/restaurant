package com.florincernat.restaurant.dao;

import com.florincernat.restaurant.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    void add(Customer customer);

    void delete(long id);

    Optional<Customer> findById(long id);

    List<Customer> findAll();
}
