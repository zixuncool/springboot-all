package com.rumo.inter;


import com.alibaba.dubbo.config.annotation.Service;

@Service
public interface DemoService {

    String sayHello(String name);

}