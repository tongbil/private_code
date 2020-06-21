package com.google.demoForIdea.common;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class 线程池 {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
				2, 5,
				10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10),
				new ThreadPoolExecutor.CallerRunsPolicy()

		);
		for (int i =0;i<20;i++){
			try{
				executor.execute(new MyRunnable("第"+(i+1)+"个"));
			}catch (Exception e){
				System.out.println("丢"+ (i+1));
			}

		}
	}
	static  class MyRunnable implements Runnable{
         private String name ;

		public  MyRunnable(String  name){
			this.name=name;
		}

		@Override
		public void run() {
			System.out.println(name);
			while (true){

			}
		}
	}
}
