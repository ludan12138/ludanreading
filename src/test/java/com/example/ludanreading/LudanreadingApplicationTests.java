package com.example.ludanreading;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class LudanreadingApplicationTests {
	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {
		
	}

	@Test
	public void getConnection() throws Exception {
		System.out.println(dataSource.getConnection());
	}
}
