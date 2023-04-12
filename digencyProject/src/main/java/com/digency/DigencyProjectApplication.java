package com.digency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

//@SpringBootApplication(scanBasePackages = {"com.digency.dao","com.digency.web"})
//@EntityScan(basePackages = {"com.digency.entities"})
//@ComponentScan(basePackages= {"com.digency.dao","com.digency.web"})
@SpringBootApplication()
@Configuration
public class DigencyProjectApplication {


	public static void main(String[] args) {
		SpringApplication.run(DigencyProjectApplication.class, args);

		System.out.println("good");




	}

}
