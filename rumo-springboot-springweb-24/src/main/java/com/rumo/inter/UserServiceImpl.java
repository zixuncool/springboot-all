package com.rumo.inter;

public class UserServiceImpl implements  IUserService {

    public void test(){}
    public void test1(){}
    public void test2(){}
    
	@Override
	public void sayhell() {
		IUserService.super.sayhell();
	}
    
}
