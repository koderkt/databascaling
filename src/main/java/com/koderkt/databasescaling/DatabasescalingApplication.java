package com.koderkt.databasescaling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class DatabasescalingApplication {

	public static void main(String[] args) {
		System.setProperty("org.mongodb.driver", "DEBUG");

		SpringApplication.run(DatabasescalingApplication.class, args);
	}

}
