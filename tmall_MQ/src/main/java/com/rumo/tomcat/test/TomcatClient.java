package com.rumo.tomcat.test;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TomcatClient {


	static int count = 0 ;

	public static void main(String[] args) {


		//Executors.newFixedThreadPool(nThreads)
		//Executors.newSingleThreadExecutor()
		//Executors.newCachedThreadPool();
		//Executors.newScheduledThreadPool(corePoolSize)

		/*Executors.newCachedThreadPool(new ThreadPoolExecutor(50, 200, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>()).getThreadFactory()).execute(new Runnable() {
			public void run() {
				while(true) {
					count++;
					System.out.println(Thread.currentThread().getName()+"====>"+count);
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});*/

		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(3),
				new MyRejected());

		MkTask task1 = new MkTask(1, "任务1");
		MkTask task2 = new MkTask(2, "任务2");
		MkTask task3 = new MkTask(3, "任务3");
		MkTask task4 = new MkTask(4, "任务4");
		MkTask task5 = new MkTask(5, "任务5");
		MkTask task6 = new MkTask(6, "任务6");

		poolExecutor.execute(task1);//corethreads去执行
		poolExecutor.execute(task2);//存放ArrayBlockingQueue
		poolExecutor.execute(task3);//存放ArrayBlockingQueue
		poolExecutor.execute(task4);//存放ArrayBlockingQueue
		poolExecutor.execute(task5);////ArrayBlockingQueue 队列已满，就开始创建新的线程
		poolExecutor.execute(task6);//因为活着的线程最大是2个，这个时候没有线程可以创建了，队列也已经满了就出现java.util.concurrent.RejectedExecutionExceptiony异常

		poolExecutor.shutdown();


	}

	public static void handler() {
		try {
			URL url = new URL("http://localhost:8080/tomcattest2/");
			URLConnection rulConnection = url.openConnection();// 此处的urlConnection对象实际上是根据URL的
			// 请求协议(此处是http)生成的URLConnection类
			// 的子类HttpURLConnection,故此处最好将其转化
			// 为HttpURLConnection类型的对象,以便用到
			// HttpURLConnection更多的API.如下:

			HttpURLConnection connection = (HttpURLConnection) rulConnection;
			//设置请求方式
			connection.setRequestMethod("GET");
			//连接
			connection.connect();
			//得到响应码
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK){
				//得到响应流
				InputStream is= connection.getInputStream();
				//将响应流转换成字符串
				byte[]buffer= new byte[1024];
				ByteArrayOutputStream baos= new ByteArrayOutputStream();
				for(int len=0;(len= is.read(buffer))>0;){
					baos.write(buffer,0, len);
				}

				String returnValue= new String(baos.toByteArray(),"utf-8");
				System.out.println(returnValue);
				baos.flush();
				baos.close();
				is.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
