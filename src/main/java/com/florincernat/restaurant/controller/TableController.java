package com.florincernat.restaurant.controller;

import com.florincernat.restaurant.dao.TableDAOImpl;
import com.florincernat.restaurant.model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tables")
public class TableController {
    @Autowired
    TableDAOImpl tableDAO;

    @GetMapping("/all")
    public String listAllTables(){
        Optional<List<Table>> tables = tableDAO.allTables();
        for(Table table : tables.get())
            System.out.println((table.getSeats()));
        return "";
    }
}
