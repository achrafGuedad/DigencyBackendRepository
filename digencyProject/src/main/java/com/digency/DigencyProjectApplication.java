package com.digency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(scanBasePackages = {"com.digency.dao","com.digency.web"})
//@EntityScan(basePackages = {"com.digency.entities"})
//@ComponentScan(basePackages= {"com.digency.dao","com.digency.web"})
@SpringBootApplication()
public class DigencyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigencyProjectApplication.class, args);

		System.out.println("good");
	}

}
