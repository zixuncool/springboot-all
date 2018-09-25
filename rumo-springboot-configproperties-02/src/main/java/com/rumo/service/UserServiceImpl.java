package com.rumo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	

	@Value("${rumo.name}")
	private String name;
	@Value("${rumo.address}")
	private String address;
	

	@Override
	public String sayHello() {
		return "Hello SpringBoott!!!";
	}
	
}

