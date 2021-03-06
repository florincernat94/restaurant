package com.florincernat.restaurant.dao;

import com.florincernat.restaurant.model.Table;

import java.util.List;
import java.util.Optional;

public interface TableDAO {
    Optional<Table> findById(Long id);
    List<Table> allTables();
    void takeTable(Long id);
    void freeTable(Long id);
    int isTableAvailable(Long id);
}
