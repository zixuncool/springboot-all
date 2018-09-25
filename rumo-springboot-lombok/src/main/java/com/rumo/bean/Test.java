package com.rumo.bean;

public class Test {

	/*
	lombok 编译时的插件--依赖开发工具--jdk在对象项目对象编译的时候，它会调用lombok插件
	然后把代码织入到class文件中。
	*/
	
	public static void main(String[] args) {
		
		User user = new User();
		user.setId(1l);
		user.setUsername("keke");
		user.setPassword("234545");
		
		System.out.println(user.getId());
		System.out.println(user.getUsername());
	}
}
