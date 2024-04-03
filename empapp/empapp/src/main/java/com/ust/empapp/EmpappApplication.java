package com.ust.empapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ust.empapp.repository")
@EnableTransactionManagement
public class EmpappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpappApplication.class, args);
	}

}
