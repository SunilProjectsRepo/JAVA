package com.sunil.daemonthreads;

import com.sunil.namingthreads.NamedThreadFactory;

public class NamedDaemonThreadFactory extends NamedThreadFactory {
	private static int count = 0;
	
	// Every alternate Thread setting it as Daemon Thread
	@Override
	public Thread newThread(Runnable r) {
		Thread t = super.newThread(r);
		if(++count % 2 == 0) {
			t.setDaemon(true);
		}
		return t;
	}
}
