package com.sunil.daemonthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaemonThreads_WithExecutor_1 {
	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" +currentThreadName+"]Main thread starts here...");
		
		ExecutorService execService = Executors
				.newCachedThreadPool(new NamedDaemonThreadFactory());
		//Even number Thread are Daemon Thread
		//We are going to make the task run successively longer
		//as per their sequence number.
		execService.execute(new LoopTaskD(100));
		execService.execute(new LoopTaskD(200));
		execService.execute(new LoopTaskD(300));
		execService.execute(new LoopTaskD(400));
		
		execService.shutdown();
		
		System.out.println("[" +currentThreadName+"]Main thread ends here...");

	}
}
