package com.rumo.inter;

public interface IUserService {


	public final  int a = 10;
	public static final  int aa = 10;
	public int num = 100;//public static final int num = 100;

     void test();
     void test1();
     abstract void test2();
    
    //抽象类，特意去制定方法默认方法
    default void sayhell() {
    	System.out.println("ccccc");
    }


}
