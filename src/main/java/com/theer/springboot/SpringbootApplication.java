package com.theer.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class SpringbootApplication {

	public static void main(String[] args) {

		ApplicationContext springboot = SpringApplication.run(SpringbootApplication.class, args);

		for (String s : springboot.getBeanDefinitionNames()) {
			System.out.println(s);
		}

	}

}
