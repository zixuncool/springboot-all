package com.rumo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rumo.mapper")
public class MainApplication /*extends SpringBootServletInitializer*/{

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApplication.class, args);
    }

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MainApplication.class);
	}*/
    
}
