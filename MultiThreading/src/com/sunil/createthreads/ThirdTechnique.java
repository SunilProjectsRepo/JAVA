package com.sunil.createthreads;

import java.util.concurrent.TimeUnit;
/* We are implementing the Runnable interface*/
public class ThirdTechnique {
	public static void main(String[] args) {
		System.out.println("Main thread starts here...");

		new ThirdTask();
		new ThirdTask();
		
		System.out.println("Main thread ends here...");
	}
}

/* As this class no longer extends Thread class, we do not have access to start()
 * Instead we will create new Thread object and pass the ThirdTask instance as task to it
 * 
 */
class ThirdTask implements Runnable{
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

	public ThirdTask() {
		this.id = ++count;
		new Thread(this).start();
	}
}

