package com.example.ludanreading;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.ludanreading.mapper")
public class LudanreadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LudanreadingApplication.class, args);
	}

}
