package com.rumo.tomcat.test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MkTask2 implements Runnable{

	
	private int taskId;
	private String taskName;
	
	
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public MkTask2(int taskId, String taskName) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
	}


	public void run() {
		try {
			System.out.println("run taskId是"+taskId+":name :"+taskName);
			Thread.sleep(100);
			handler();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public  void handler() {
		try {
			URL url = new URL("http://localhost:8080/testtomcat/");
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

				//String returnValue= new String(baos.toByteArray(),"utf-8");
				//System.out.println(returnValue);
				System.out.println("tomcat success!!!!");
				baos.flush();
				baos.close();
				is.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "MkTask [taskId=" + taskId + ", taskName=" + taskName + "]";
	}
	
}
