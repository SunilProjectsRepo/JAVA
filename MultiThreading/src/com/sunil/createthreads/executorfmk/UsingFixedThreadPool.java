package com.sunil.createthreads.executorfmk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFixedThreadPool {
	public static void main(String[] args) {
		System.out.println("Main thread starts here...");
		
		ExecutorService execService = Executors.newFixedThreadPool(3);
		for(int i=0; i<6; i++) {
			execService.execute(new LoopTaskA());
		}
		
		execService.shutdown();
		//execService.execute(new LoopTaskA());
 
		System.out.println("Main thread ends here...");
	}
}
