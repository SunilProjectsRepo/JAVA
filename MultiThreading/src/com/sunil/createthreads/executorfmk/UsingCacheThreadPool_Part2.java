package com.sunil.createthreads.executorfmk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.sunil.namingthreads.LoopTaskC;
import com.sunil.namingthreads.NamedThreadFactory;

/* 
 * We will look how the thread reuse by CacheThreadPool internally
 * whenever previously created threads become free.
 */
public class UsingCacheThreadPool_Part2 {
	public static void main(String[] args) {
		System.out.println("Main thread starts here...");
		
		ExecutorService execService = Executors
				.newCachedThreadPool(new NamedThreadFactory());
		for(int i=0; i<3; i++) {
			execService.execute(new LoopTaskC());
		}
		
		try {
			//Task will sleep for random period between 0 - 1000 seconds
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Submitting more tasks now...");
		for(int i=0; i<5; i++) {
			execService.execute(new LoopTaskC());
		}
		
		execService.shutdown();
		//execService.execute(new LoopTaskA());
 
		System.out.println("Main thread ends here...");
	}
}
