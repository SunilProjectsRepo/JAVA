package com.sunil.createthreads.executorfmk;

import java.util.concurrent.TimeUnit;

public class LoopTaskA implements Runnable{
	private static int count = 0;
	private int id;
	@Override
	public void run() {
		System.out.println("##### <TASK-" +id+"> STARTING ########");
		for(int i=1; i<=10; i++) {
			System.out.println("<"+id+">"+"TICK TICK - "+ i);
			try {
				//Task will sleep for random period between 0 - 1000 seconds
				TimeUnit.MILLISECONDS.sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("##### <TASK-" +id+"> COMPLETED ########");
	}
	public LoopTaskA() {
		this.id = ++count;
	}
}
