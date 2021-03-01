package edu.uark.registerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class RegisterApplication {

	public static void main(final String[] args) {
		SpringApplication.run(RegisterApplication.class, args);
	}

}
