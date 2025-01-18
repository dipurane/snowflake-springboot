package com.demo.snowflake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnowflakeApplication {


	public static void main(String[] args) {
		System.setProperty("add-opens java.base/java.nio", "ALL-UNNAMED");
		SpringApplication.run(SnowflakeApplication.class, args);
	}

}
