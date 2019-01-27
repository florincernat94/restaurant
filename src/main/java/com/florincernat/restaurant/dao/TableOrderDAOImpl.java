package com.florincernat.restaurant.dao;

import com.florincernat.restaurant.model.TableOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class TableOrderDAOImpl implements TableOrderDAO {
    private static final String ADD_ORDER_QUERY = "insert into table_order (id,table_id,order_date)" +
            " values (generate_id('table_order'),:table_id,CURRENT_TIMESTAMP)";
    private static final String FIND_ORDER_QUERY = "select * from table_order where id =:id";
    private static final String GET_ORDER_AMOUNT_QUERY = "select sum(it.price * od.QUANTITY) from item" +
            " it join ORDER_DETAILS od on it.id=od.ITEM_ID where od.ORDER_ID= ?";

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<TableOrder> findById(long id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        return Optional.ofNullable(namedJdbcTemplate.queryForObject(FIND_ORDER_QUERY, paramMap, new TableOrderRowMapper()));
    }

    @Override
    public void addOrder(TableOrder order) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", order.getId());
        namedJdbcTemplate.update(ADD_ORDER_QUERY, paramMap);
    }

    @Override
    public float getOrderAmount(long orderId) {
        return jdbcTemplate.queryForObject(GET_ORDER_AMOUNT_QUERY, new Object[]{orderId}, Float.class);
    }

    private static final class TableOrderRowMapper implements RowMapper<TableOrder> {

        @Override
        public TableOrder mapRow(ResultSet resultSet, int i) throws SQLException {
            TableOrder tableOrder = new TableOrder();
            tableOrder.setId(resultSet.getLong("id"));
            tableOrder.setTableId(resultSet.getLong("table_id"));
            tableOrder.setOrderDate(resultSet.getDate("order_date"));
            return tableOrder;
        }
    }
}
