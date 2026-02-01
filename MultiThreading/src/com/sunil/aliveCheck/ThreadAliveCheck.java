package com.sunil.aliveCheck;

import java.util.concurrent.TimeUnit;

import com.sunil.daemonthreads.LoopTaskD;
import com.sunil.namingthreads.LoopTaskC;
/* 
 * We will create two threads and then check them for being alive
 * before starting them. After that, we are going to start them and 
 * then continue checking them for being alive in a loop till both
 * the threads finish executing.
 */
public class ThreadAliveCheck {
	public static void main(String[] args) throws InterruptedException{
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" +currentThreadName+"]Main thread starts here...");
		
		Thread t1 = new Thread(new LoopTaskC(), "Thread-1");
		Thread t2 = new Thread(new LoopTaskC(), "Thread-2");

		boolean t1IsAlive = t1.isAlive();
		boolean t2IsAlive = t2.isAlive();
		
		System.out.println("[" +currentThreadName+"] Before"
				+ "starting: Is '"+t1.getName()+ "' alive = "+t1IsAlive);
		System.out.println("[" +currentThreadName+"] Before"
				+ "starting: Is '"+t2.getName()+ "' alive = "+t2IsAlive);
		
		t1.start();
		t2.start();
		
		while(true) {
			TimeUnit.MILLISECONDS.sleep(2);
			t1IsAlive = t1.isAlive();
			t2IsAlive = t2.isAlive();
			System.out.println("[" +currentThreadName+"] "
					+ "Is '"+t1.getName()+ "' alive = "+t1IsAlive);
			System.out.println("[" +currentThreadName+"] "
					+ "Is '"+t2.getName()+ "' alive = "+t2IsAlive);
			if(!t1IsAlive && !t2IsAlive)
				break;
		}
		System.out.println("[" +currentThreadName+"]Main thread ends here...");

	}
}
