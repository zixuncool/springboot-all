package com.rumo.rumodubboconsumer.web;

import com.rumo.rumodubboconsumer.service.DubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoConsumerController {

    @Autowired
    private DubboConsumerService dubboConsumerService;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        return dubboConsumerService.sayHello(name);
    }

}