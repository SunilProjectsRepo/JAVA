package com.sunil.namingthreads;

import java.util.concurrent.TimeUnit;

public class LoopTaskC1 implements Runnable{
	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	
	@Override
	public void run() {
		//To get the instance of current thread
		//String currentThreadName = Thread.currentThread().getName();
		System.out.println("##### [" +Thread.currentThread().getName()+"] <" +taskId +"> STARTING ########");
		for(int i=1; i<=10; i++) {
			System.out.println("[" +Thread.currentThread().getName()+"] <"+taskId+">"+"TICK TICK - "+ i);
			try {
				//Task will sleep for random period between 0 - 1000 seconds
				TimeUnit.MILLISECONDS.sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("##### [" +Thread.currentThread().getName()+"] <"+taskId+"> COMPLETED ########");
	}
	public LoopTaskC1() {
		this.instanceNumber = ++count;
		this.taskId = "LoopTaskC1" +instanceNumber;
	}
}
