package com.capgemini.microtypi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
//escanea paquetes de controlador y service
@SpringBootApplication(scanBasePackages = {"com.capgemini.microtypi.web", "com.caixaba.absis.microtypi.service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
}