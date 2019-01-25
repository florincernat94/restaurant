package com.florincernat.restaurant.controller;

import com.florincernat.restaurant.dao.CustomerDAOImpl;
import com.florincernat.restaurant.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerDAOImpl customerDAO;

    @GetMapping("/register")
    public String registerCustomer() {
        Customer customer = new Customer("florincernat94@gmail.com","parola","Iasi");
        customerDAO.add(customer);
        return "index";
    }
}
