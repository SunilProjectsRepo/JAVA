package com.sunil.returningvalues.executorfmk;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.sunil.createthreads.executorfmk.LoopTaskA;

/*
 * Here, we want to process the results from the tasks 
 * in the sequence in which they are completed. 
 */
public class ReturningValuesUsingExecutors_SecondTechnique {
	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" +currentThreadName+"]Main thread starts here...");
		
		ExecutorService execService = Executors.newCachedThreadPool();
		
		CompletionService<TaskResult<String, Integer>> completionService = new ExecutorCompletionService<TaskResult<String,Integer>>(execService);
		
		completionService.submit(new CalculationTaskB(2,3,2000));
		completionService.submit(new CalculationTaskB(3,4,1000));
		completionService.submit(new CalculationTaskB(4,5,500));

		//Is not supported in CompletionService interface, no method with single Runnable parameter
		//Future<?> result4 = execService.submit(new LoopTaskA());
		
		//Is supported in CompletionService interface, no method with single Runnable parameter, 2nd parameter is Integer value
		completionService.submit(new LoopTaskA(), new TaskResult<String, Integer>("LoopTask-1", 999));

		
		execService.shutdown();
		
		for(int i=0; i<4; i++) {
			try {
				System.out.println(completionService.take().get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("[" +currentThreadName+"]Main thread ends here...");
	}
}
