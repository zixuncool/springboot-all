package com.rumo.rumodubboconsumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rumo.inter.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DubboConsumerService {

    @Reference(url = "dubbo://127.0.0.1:20880")
    DemoService demoService;

   /* @Autowired
    private SampleService sampleService;*/

    public String sayHello(String name) {
        return demoService.sayHello(name);
    }
}