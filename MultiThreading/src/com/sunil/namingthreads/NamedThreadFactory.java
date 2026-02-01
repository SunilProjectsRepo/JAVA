package com.sunil.namingthreads;

import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory implements ThreadFactory{
	private static int count = 0;
	private static String NAME = "PoolWorker-";
	// This Runnable is generated internally by the JVM
	// Note: This is not the Runnable task that we submit to the Executor Service
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, NAME + ++count);
		return t;
	}
	

}
