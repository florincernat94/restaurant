package com.florincernat.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tables")
public class TableController {

    @GetMapping("/all")
    public String listAllTables(){
        return "";
    }
}