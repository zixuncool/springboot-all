package com.rumo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RumoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RumoApplication.class, args);
	}
}
