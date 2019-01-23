package com.florincernat.restaurant.dao;

import com.florincernat.restaurant.model.Table;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TableDAOImpl implements TableDAO{
    NamedParameterJdbcTemplate namedJdbcTemplate;

    private static final String FIND_TABLE_QUERY = "select id,seats,taken from table where id=:id";

    @Override
    public Optional<Table> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Table>> allTables() {
        return Optional.empty();
    }

    @Override
    public void takeTable(Long id) {

    }
}
