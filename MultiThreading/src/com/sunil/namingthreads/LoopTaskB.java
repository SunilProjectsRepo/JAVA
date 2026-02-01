package com.sunil.namingthreads;

import java.util.concurrent.TimeUnit;

public class LoopTaskB implements Runnable{
	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	
	@Override
	public void run() {
		//Setting the Name of the Thread
		Thread.currentThread().setName("Worker-" + instanceNumber);
		//To get the instance of current thread
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("##### [" +currentThreadName+"] <" +taskId +"> STARTING ########");
		for(int i=1; i<=10; i++) {
			System.out.println("[" +currentThreadName+"] <"+taskId+">"+"TICK TICK - "+ i);
			try {
				//Task will sleep for random period between 0 - 1000 seconds
				TimeUnit.MILLISECONDS.sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("##### [" +currentThreadName+"] <"+taskId+"> COMPLETED ########");
	}
	public LoopTaskB() {
		this.instanceNumber = ++count;
		this.taskId = "LoopTaskB" +instanceNumber;
	}
}
