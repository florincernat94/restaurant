package com.florincernat.restaurant.dao;

import com.florincernat.restaurant.model.Table;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class TableDAOImpl implements TableDAO {
    Logger logger = Logger.getLogger(getClass());

    NamedParameterJdbcTemplate namedJdbcTemplate;
    JdbcTemplate jdbcTemplate;

    private static final String FIND_TABLE_QUERY = "select id,seats,available from tables where id=:id";
    private static final String IS_TABLE_AVAILABLE_QUERY = "select available from tables where id=:id";
    private static final String TAKE_TABLE_QUERY = "update table tables set available=:available where id=:id";
    private static final String GET_ALL_TABLES = "select available from tables where id=:id";


    @Override
    public Optional<Table> findById(Long id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        return Optional.ofNullable(namedJdbcTemplate.queryForObject(FIND_TABLE_QUERY, paramMap, new TableRowMapper()));
    }

    @Override
    public Optional<List<Table>> allTables() {
        return Optional.ofNullable(jdbcTemplate.queryForList(GET_ALL_TABLES,Table.class,new TableRowMapper()));
    }

    @Override
    public void takeTable(Long id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        paramMap.put("available", 1);
        namedJdbcTemplate.update(TAKE_TABLE_QUERY, paramMap);
    }

    @Override
    public Optional<Integer> isTableAvailable(Long id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        //return Optional.ofNullable(namedJdbcTemplate.queryForObject(IS_TABLE_AVAILABLE_QUERY,paramMap,new TableRowMapper()).isAvailable());
        return Optional.empty();
    }

    private static final class TableRowMapper implements RowMapper<Table> {

        @Override
        public Table mapRow(ResultSet resultSet, int i) throws SQLException {
            Table table = new Table();
            table.setId(resultSet.getLong("id"));
            table.setSeats(resultSet.getInt("seats"));
            table.setAvailable(resultSet.getInt("available"));
            return table;
        }
    }
}
