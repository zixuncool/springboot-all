package com.rumo.thread.wait;

import java.util.ArrayList;
import java.util.List;


/**
 * 线程之间通讯：线程是操作系统中独立的个体，但这些个人如果不经过特殊的处理就不能成为一个整体，
 * 线程间的通信就成为整体的必用方式之一，当线程存在通信指挥，熊健的交互性会更强大，在提高cpu利用率
 * 的同时，还会使开发人员对线程任务在处理的过程中进行有效的把控与监督。
 * 使用wait/notify方法实现线程间的通信。（注意这两个方法都是object的类的方法，换句话说java为所以的对象
 * 提供了这两个方法）
 * 1：wati和notify必须配合synchronized关键字使用
 * 2:wait方法释放锁，notify方法不释放锁
 */
public class ListAdd1 {

	
	private volatile static List list = new ArrayList();	
	
	public void add(){
		list.add("bjsxt");
	}
	public int size(){
		return list.size();
	}
	
	public static void main(String[] args) {
		
		final ListAdd1 list1 = new ListAdd1();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for(int i = 0; i <10; i++){
						list1.add();
						System.out.println("当前线程：" + Thread.currentThread().getName() + "添加了一个元素..");
						Thread.sleep(500);
					}	
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					if(list1.size() == 5){
						System.out.println("当前线程收到通知：" + Thread.currentThread().getName() + " list size = 5 线程停止..");
						throw new RuntimeException();
					}
				}
			}
		}, "t2");		
		
		t1.start();
		t2.start();
	}
	
	
}
