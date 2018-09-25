package com.rumo.rumodubboprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.rumo.inter.DemoService;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = DemoService.class)
public class DefaultDemoService implements DemoService {
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }
}