package com.rumo.tomcat.test;

public class MkTask implements Runnable{

	
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


	public MkTask(int taskId, String taskName) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
	}


	public void run() {
		try {
			System.out.println("run taskId是:"+taskId+":name :"+taskName);
			Thread.sleep(5*1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "MkTask [taskId=" + taskId + ", taskName=" + taskName + "]";
	}
	
}
