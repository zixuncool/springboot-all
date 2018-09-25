package com.rumo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//此配置在自动加载springboot管理的所有配置类，这个配置会自动根据你pom.xml文件中的依赖有关，
/*
* 
* 	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
	会自动把springboot中的配置包中中关于spring-boot-starter-web的配置加载到spring容器进行管理。
* spring-boot-autoconfigure-2.0.4.RELEASE.jar
* @EnableAutoConfiguration此注解是把所有项目pom.xml中依赖配置类全部找出来，放入到set集合中。然后让容器去初始化
* */
//吧pom.xml相关的依赖配置类 xxxxxxAutoConfiguration-
//@EnableAutoConfiguration
////此注解标准为springmvc控制器类
//@ComponentScan("com.rumo.service")
//@SpringBootConfiguration
@SpringBootApplication
public class RumoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RumoApplication.class, args);
	}
	
}
