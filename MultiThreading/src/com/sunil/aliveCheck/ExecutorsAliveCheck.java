package com.sunil.aliveCheck;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.sunil.namingthreads.LoopTaskC;
import com.sunil.namingthreads.NamedThreadFactory;
import com.sunil.returningvalues.executorfmk.CalculationTaskA;

/* We are actually interested in checking task completion!!! */
public class ExecutorsAliveCheck {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" +currentThreadName+"]Main thread starts here...");
		
		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());
		
		Future<?> f1 = execService.submit(new LoopTaskC());
		Future<Integer> f2 = execService.submit(new CalculationTaskA(3,4,100));
		execService.shutdown();
		//In the loop, we are not waiting for the both the tasks to be finished
		for(int i=1; i<=5; i++) {
			TimeUnit.MILLISECONDS.sleep(10);
			System.out.println("["+currentThreadName+"] ITR-"+i+" -> Is 'LoopTaskC-1' done = "+f1.isDone());
			System.out.println("["+currentThreadName+"] ITR-"+i+" -> Is 'CalcTaskA-1' done = "+f1.isDone());
		}
		System.out.println("$$$$ ["+currentThreadName+"] Retrieving results now .... $$$$$");
		System.out.println("["+currentThreadName+"] 'LoopTaskC-1' result = "+f1.get());
		System.out.println("["+currentThreadName+"] 'CalcTaskA-1' result = "+f2.get());

		System.out.println("[" +currentThreadName+"]Main thread ends here...");

	}

}
