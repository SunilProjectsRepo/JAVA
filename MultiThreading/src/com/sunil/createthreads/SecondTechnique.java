package com.sunil.createthreads;

import java.util.concurrent.TimeUnit;
/*We are starting the Thread from another class rather that the constructor
 * of the thread .
 * This gives more control to the calling code as to when to start the thread.
 */
public class SecondTechnique {
	public static void main(String[] args) {
		System.out.println("Main thread starts here...");
		
		new SecondTask().start();
		
		Thread t = new SecondTask();
		t.start();
		System.out.println("Main thread ends here...");
	}
}

class SecondTask extends Thread{
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
	public SecondTask() {
		this.id =  ++count;
	}
}
