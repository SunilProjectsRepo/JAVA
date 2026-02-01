package com.sunil.createthreads;

import java.util.concurrent.TimeUnit;

/* This is a Quick and Dirty Technique 
 * We are going to use an inline task definition by using an anonymous inner class implementating runnable interface
 * We will provide the this task definition to a thread object and 
 * then invoke the start method on that Thread object.
 * We have a Two thread. 
 * The main thread starts a child thread and then ends.
 * The child thread then gets the CPU and executes job and after completing the jobs, it ends.
 * */
public class FifthTechnique {
	public static void main(String[] args) {
		System.out.println("Main Thread starts here ...");
		
		Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					//In reality, we don't know which thread is going to get the CPU
					//so you won't get the same output everytime you run the program.
					for(int i=1; i<=10; i++) {
						System.out.println("TICK TICK - "+ i);
						try {
							TimeUnit.MILLISECONDS.sleep(250);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		});
		t.start();
		
		System.out.println("Main Thread ends here ...");
	}
}
