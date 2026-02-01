package com.sunil.namingthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThirdTechnique_NamingThreads_UsingExecutorThreads {
	public static void main(String[] args) {
		System.out.println("Main thread starts here...");
		
		ExecutorService execService = Executors
				.newCachedThreadPool(new NamedThreadFactory());
		for(int i=0; i<3; i++) {
			execService.execute(new LoopTaskC());
		}
		
		execService.shutdown();
		//execService.execute(new LoopTaskA());
 
		System.out.println("Main thread ends here...");
	}
}
