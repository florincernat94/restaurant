package com.florincernat.restaurant.dao;

import com.florincernat.restaurant.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CustomerDAOImpl implements CustomerDAO {
    private static final String ADD_CUSTOMER_QUERY = "insert into customer (id,email,address,password)" +
            " values (generate_id('customer'),:email,:address,:password)";
    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;
    private static final String DELETE_CUSTOMER_QUERY = "delete from customer where id =:id";
    private static final String FIND_CUSTOMER_QUERY = "select * from customer where id =:id";

    @Override
    public void add(Customer customer) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("email", customer.getEmail());
        paramMap.put("address", customer.getAddress());
        paramMap.put("password", customer.getPassword());
        namedJdbcTemplate.update(ADD_CUSTOMER_QUERY, paramMap);
    }

    @Override
    public void delete(long id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        namedJdbcTemplate.update(DELETE_CUSTOMER_QUERY, paramMap);
    }

    @Override
    public Optional<Customer> findById(long id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        Optional<Customer> customer = Optional.ofNullable(namedJdbcTemplate.queryForObject(FIND_CUSTOMER_QUERY, paramMap, new CustomerRowMapper()));
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    private static final class CustomerRowMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            Customer customer = new Customer();
            customer.setId(resultSet.getInt("id"));
            customer.setEmail(resultSet.getString("email"));
            customer.setPassword(resultSet.getString("password"));
            customer.setAddress(resultSet.getString("address"));
            return customer;
        }
    }
}
