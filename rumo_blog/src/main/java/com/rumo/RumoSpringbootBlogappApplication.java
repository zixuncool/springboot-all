package com.rumo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.rumo.mapper")
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
public class RumoSpringbootBlogappApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RumoSpringbootBlogappApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RumoSpringbootBlogappApplication.class);
	}
	
}
