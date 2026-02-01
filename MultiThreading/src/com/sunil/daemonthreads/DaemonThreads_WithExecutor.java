package com.sunil.daemonthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaemonThreads_WithExecutor {
	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" +currentThreadName+"]Main thread starts here...");
		
		ExecutorService execService = Executors
				.newCachedThreadPool(new NamedDaemonThreadFactory());
		//Even number Thread are Daemon Thread
		//Setting the time more for Even Threads.
		//We expect tasks 2 & 4 to run longer than 1 & 3
		execService.execute(new LoopTaskD(100));
		execService.execute(new LoopTaskD(400));
		execService.execute(new LoopTaskD(100));
		execService.execute(new LoopTaskD(400));
		
		execService.shutdown();
		
		System.out.println("[" +currentThreadName+"]Main thread ends here...");

	}
}
