package com.florincernat.restaurant;

import com.florincernat.restaurant.dao.TableDAOImpl;
import com.florincernat.restaurant.dao.TableOrderDAOImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantApplicationTests {
	@Autowired
	TableDAOImpl tableDAO;

	@Autowired
	TableOrderDAOImpl tableOrder;

	@Test
	public void contextLoads() {
	}

	@Test
	public void tableQueries(){
		System.out.println(tableDAO.isTableAvailable(1L));
	}

	@Test
	public void testOrderAmount(){
		System.out.println(tableOrder.getOrderAmount(3));
	}

}

