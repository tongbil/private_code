package com.google.demoForIdea.common;

public class 线程可见性

{
private  static  volatile boolean flag =false;
	public static void main(String[] args) throws InterruptedException {
		new Thread(()->{
			System.out.println("1号线程启动 ");
			long num =0;
			while (!flag){
				num++;
			}
			System.out.println(num);
		}).start();
		Thread.sleep(1000);

		 new Thread(()->{
			 System.out.println("2号线程启动");
			 setStop();
		 }).start();
	}
	 static void setStop(){
		 flag=true;
	 }
}
