package com.sunil.namingthreads;

import java.util.concurrent.TimeUnit;

/* Naming Threads - At the time of Thread Creation */
public class SecondTechnique_AtThreadCreation_AfterSomeTime {
	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" +currentThreadName+"]Main thread starts here...");
		
		//First way we can use the two arguments.
		//Constructor of the Thread class that takes a name in addition to a Runnable
		new Thread(new LoopTaskC1(), "Worker-1").start();
		Thread t2 = new Thread(new LoopTaskC1());
		//Second way we can name the thread after it has been created by using the setName()
		//After sometime
		//t2.setName("Worker-2");
		t2.start();

		try {
			//Task will sleep for random period between 0 - 1000 seconds
			TimeUnit.MILLISECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[" +currentThreadName+"] Renaming second Thread...");
		t2.setName("Worker-2");

		System.out.println("[" +currentThreadName+"] Main thread ends here...");
	}
}
