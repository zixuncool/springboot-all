package com.rumo.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rumo.service.IUserService;

@Component
public class TaskJobConfiguration {

	
	@Autowired
	private IUserService userService;
	
	
	/*@Scheduled(fixedRate=1000)
	public void createTask() {
		String content = userService.sayHello();
		System.out.println(content);
	}*/
	
	
	@Scheduled(cron="*/5 * * * * ?")
	public void createTask() {
		String content = userService.sayHello();
		System.out.println(content);
	}
	
}
