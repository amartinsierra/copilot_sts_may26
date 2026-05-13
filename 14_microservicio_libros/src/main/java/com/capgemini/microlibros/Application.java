package com.capgemini.microlibros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.capgemini.microlibros", "com.caixaba.absis.microlibros.service", "com.caixaba.absis.microlibros.web", "com.caixaba.absis.microlibros.mapper"})
@EntityScan(basePackages = "com.caixaba.absis.microlibros.entity")
@EnableJpaRepositories(basePackages = "com.caixaba.absis.microlibros.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}