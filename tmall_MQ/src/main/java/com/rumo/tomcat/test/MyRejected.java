package com.rumo.tomcat.test;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejected implements RejectedExecutionHandler {

	public MyRejected() {
		
	}

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("自定义处理，队列和线程已满，已被拒绝!");
		System.out.println("被拒绝的任务为："+r.toString());
	}
	
	
}
