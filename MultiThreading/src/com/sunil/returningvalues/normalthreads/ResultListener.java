package com.sunil.returningvalues.normalthreads;

public interface ResultListener<T> {
	void notifyResult(T result);
}
