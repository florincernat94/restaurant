package com.florincernat.restaurant;

import com.florincernat.restaurant.dao.TableDAOImpl;
import com.florincernat.restaurant.model.Table;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantApplicationTests {
	@Autowired
	TableDAOImpl tableDAO;

	@Test
	public void contextLoads() {
	}

	@Test
	public void tableQueries(){
		System.out.println(tableDAO.isTableAvailable(1L));
	}

}

