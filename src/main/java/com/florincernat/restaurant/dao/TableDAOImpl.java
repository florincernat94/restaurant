package com.florincernat.restaurant.dao;

import com.florincernat.restaurant.model.Table;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String FIND_TABLE_QUERY = "select id,seats,available from tables where id=:id";
    private static final String IS_TABLE_AVAILABLE_QUERY = "select available from tables where id=:id";
    private static final String TAKE_TABLE_QUERY = "update table tables set available=:available where id=:id";
    private static final String GET_ALL_TABLES = "select * from tables";


    @Override
    public Optional<Table> findById(Long id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        return Optional.ofNullable(namedJdbcTemplate.queryForObject(FIND_TABLE_QUERY, paramMap, new TableRowMapper()));
    }

    @Override
    public List<Table> allTables() {
        return jdbcTemplate.query(GET_ALL_TABLES, new TableRowMapper());
    }

    @Override
    public void takeTable(Long id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        paramMap.put("available", 1);
        if(isTableAvailable(id)==0)
            namedJdbcTemplate.update(TAKE_TABLE_QUERY, paramMap);
    }

    @Override
    public void freeTable(Long id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        paramMap.put("available", 0);
        if(isTableAvailable(id)==1)
            namedJdbcTemplate.update(TAKE_TABLE_QUERY, paramMap);
    }

    @Override
    public int isTableAvailable(Long id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        return namedJdbcTemplate.queryForObject(IS_TABLE_AVAILABLE_QUERY, paramMap, Integer.class);
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
