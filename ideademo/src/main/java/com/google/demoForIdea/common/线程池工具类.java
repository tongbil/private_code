package com.google.demoForIdea.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class 线程池工具类 {
	public static void main(String[] args) {
		//pool1();
		//pool2();
		pool3();
		//pool4();
	}
	public  static  void pool1(){
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i=0;i<10;i++){
			es.execute(()->{
				for(int j=0;j<10;j++){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+":"+j);
				}
			});
		}
es.shutdown();
	}
	public  static  void pool2(){
		ExecutorService es = Executors.newFixedThreadPool(2);
		for (int i=0;i<10;i++){
			es.execute(()->{
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				for(int j=0;j<10;j++){
					System.out.println(Thread.currentThread().getName()+":"+j);
				}
			});
		}
		es.shutdown();
	}
	public  static  void pool3(){
		ExecutorService es = Executors.newSingleThreadExecutor();
		for (int i=0;i<10;i++){
			es.execute(()->{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for(int j=0;j<10;j++){
					System.out.println(Thread.currentThread().getName()+":"+j);
				}
			});
		}
		es.shutdown();
	}
	public  static  void pool4(){
	ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
	//延迟4分钟
		scheduledThreadPool.schedule (new Runnable() {
			@Override
			public void run() {
				System.out.println("i"+1);
			}
		},4, TimeUnit.SECONDS);
	}
}
