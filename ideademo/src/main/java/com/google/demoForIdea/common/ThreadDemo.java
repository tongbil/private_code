package com.google.demoForIdea.common;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
	public static void main(String[] args) {
		//继承runnable
		Thread thread = new Thread(()->{

		});
		//带返回值的
		FutureTask<String> ft = new FutureTask<>(new MyCallable());
		Thread thread1 = new Thread(ft);
		thread1.start();
		try {
			String result =ft.get();
			System.out.println(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	static  class MyCallable implements Callable<String>{

		@Override
		public String call() throws Exception {
			return "我是结果";
		}
	}
}
