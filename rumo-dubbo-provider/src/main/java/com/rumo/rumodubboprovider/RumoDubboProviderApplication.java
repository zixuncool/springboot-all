package com.rumo.rumodubboprovider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ImportResource("classpath:sample-provider.xml")
@EnableDubboConfiguration
public class RumoDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RumoDubboProviderApplication.class, args);
    }
}
