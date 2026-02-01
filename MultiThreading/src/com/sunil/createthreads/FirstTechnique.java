package com.sunil.createthreads;

import java.util.concurrent.TimeUnit;
/*We are starting the Thread using constructor */
public class FirstTechnique {
	public static void main(String[] args) {
		System.out.println("Main thread starts here...");

		//As soon as we create the instance of FirstTask class, 
		//start() method of Thread class is called
		//This will start the Thread immediately
		new FirstTask();
		//To capture the thread reference, then we can do 
		// all sorts of things to control the thread of execution
		//rename the thread, join it, check if the thread is running or finished
		Thread t = new FirstTask();
		System.out.println("Main thread ends here...");
	}
}

class FirstTask extends Thread{
	//Counts the number of instances of task class
	private static int count = 0;
	//variable to hold the ID of the task instance
	private int id;
	@Override
	public void run() {
		//In reality, we don't know which thread is going to get the CPU
		//so you won't get the same output everytime you run the program.
		for(int i=1; i<=10; i++) {
			System.out.println("<"+id+">"+"TICK TICK - "+ i);
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public FirstTask() {
		this.id =  ++count;
		this.start();
	}
}
