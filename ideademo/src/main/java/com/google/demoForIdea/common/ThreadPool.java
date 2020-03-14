package com.google.demoForIdea.common;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadPool {
	private static final ExecutorService pool2 = Executors.newFixedThreadPool(2);
	private static ExecutorService getExecutor(){
		return pool2;
	}
	public static void execute(Runnable task){
		getExecutor().execute(task);
	}
}
