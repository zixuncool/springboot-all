package com.rumo.rumodubboconsumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
//@ImportResource("classpath:sample-consumer.xml")
public class RumoDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RumoDubboConsumerApplication.class, args);
    }
}
