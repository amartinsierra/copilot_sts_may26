package com.capgemini.micropersonas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.caixaba.absis.micropersonas.service", "com.capgemini.micropersonas.web", "com.capgemini.micropersonas.security", "com.caixaba.absis.micropersonas.exceptions", "com.caixaba.absis.micropersonas.mapper"})
@EnableJpaRepositories(basePackages = "com.caixaba.absis.micropersonas.repository")
@EntityScan(basePackages = "com.caixaba.absis.micropersonas.entity")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
