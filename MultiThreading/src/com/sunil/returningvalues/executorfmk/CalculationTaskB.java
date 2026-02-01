package com.sunil.returningvalues.executorfmk;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.sunil.returningvalues.normalthreads.ResultListener;

public class CalculationTaskB implements Callable<TaskResult<String, Integer>>{
	private int a;
	private int b;
	private long sleepTime;
	
	private static int count = 0;
	private int instanceNumber;
	private String taskId;	
	
	public CalculationTaskB(int a, int b, long sleepTime) {
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;
		
		this.instanceNumber = ++count;
		this.taskId = "ValueReturningTaskA-" +instanceNumber;
	}
	
	@Override
	public TaskResult<String, Integer> call() throws Exception{
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("##### [" +currentThreadName+"] <" +taskId +"> STARTING ########");
			
		//Task will sleep for random period between 0 - 1000 seconds
		TimeUnit.MILLISECONDS.sleep(sleepTime);

		
		System.out.println("##### [" +currentThreadName+"] <" +taskId +"> CALCULATION COMPLETED ########");
		return new TaskResult<String, Integer>(taskId, a + b);
	}
}
