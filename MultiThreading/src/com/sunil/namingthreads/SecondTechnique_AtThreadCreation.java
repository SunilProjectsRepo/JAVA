package com.sunil.namingthreads;
/* Naming Threads - At the time of Thread Creation */
public class SecondTechnique_AtThreadCreation {
	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" +currentThreadName+"]Main thread starts here...");
		
		//First way we can use the two arguments.
		//Constructor of the Thread class that takes a name in addition to a Runnable
		new Thread(new LoopTaskC(), "Worker-1").start();
		Thread t2 = new Thread(new LoopTaskC());
		//Second way we can name the thread after it has been created by using the setName()
		t2.setName("Worker-2");
		t2.start();

		System.out.println("[" +currentThreadName+"] Main thread ends here...");
	}
}
