package com.pistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={
		DataSourceTransactionManagerAutoConfiguration.class,
		DataSourceAutoConfiguration.class
})
public class PiStoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiStoryApplication.class, args);
	}
}
