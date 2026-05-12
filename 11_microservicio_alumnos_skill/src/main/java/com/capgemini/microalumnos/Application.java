package com.capgemini.microalumnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
	scanBasePackages = {
		"com.capgemini.microalumnos",
		"com.caixaba.absis.microalumnos"
	}
)
@EnableJpaRepositories(basePackages = "com.caixaba.absis.microalumnos.repository")
@EntityScan(basePackages = "com.caixaba.absis.microalumnos.entity")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
