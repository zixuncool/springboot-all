package com.rumo.tomcat.test;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class TomcatClient2 {


	static int count = 0 ;

	public static void main(String[] args) {


		//Executors.newFixedThreadPool(nThreads)
		//Executors.newSingleThreadExecutor()
		//Executors.newScheduledThreadPool(corePoolSize)

		ThreadPoolExecutor pool = new ThreadPoolExecutor(200, 200, 60, TimeUnit.SECONDS, new SynchronousQueue(),
				new MyRejected());


		//while(true) {
			for (int i = 1; i <200; i++) {
				MkTask2 mkTask2 = new MkTask2(i, "任务"+i);
				pool.execute(mkTask2);
			}
		//}
		//200的并发    需要tomcat8的线程BIO数量是：
	}
}
