package com.rumo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//scanBasePackages数组，如果只有一个参数的时候，可以用{}包裹，也可以不用，反之，并且用逗号隔开
//@SpringBootApplication(scanBasePackages= {"com.mofeng"})
//注意：scanBasePackage会覆盖默认的加载机制，必须要把com.rumo也要配置进去
@SpringBootApplication//(scanBasePackages= {"com.mofeng","com.rumo"})
//还原和加载spring原始的xml进行已融合
//@ImportResource(locations= {"classpath:config/applicationContext.xml",
//		"classpath:config/applicationContext-*.xml"})
public class RumoSpringbootConfigimportresource20Application {

	public static void main(String[] args) {
		SpringApplication.run(RumoSpringbootConfigimportresource20Application.class, args);
	}
	
	
} 
