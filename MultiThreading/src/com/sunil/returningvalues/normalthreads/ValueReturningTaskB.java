package com.sunil.returningvalues.normalthreads;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskB implements Runnable{
	private int a;
	private int b;
	private long sleepTime;
	private int sum;
	
	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	
	private ResultListener<Integer> resultProcessor;
	
	
	public ValueReturningTaskB(int a, int b, long sleepTime, ResultListener<Integer> resultProcessor) {
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;
		this.resultProcessor = resultProcessor;
		
		this.instanceNumber = ++count;
		this.taskId = "ValueReturningTaskA-" +instanceNumber;
	}
	
	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("##### [" +currentThreadName+"] <" +taskId +"> STARTING ########");
			
		try {
			//Task will sleep for random period between 0 - 1000 seconds
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sum = a + b;
		
		resultProcessor.notifyResult(sum);
		
		System.out.println("##### [" +currentThreadName+"] <" +taskId +"> CALCULATION COMPLETED ########");

	}
	
	
	

}
