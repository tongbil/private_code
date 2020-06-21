package com.google.demoForIdea.common;

public class 线程优先级 {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
		 for (int i=0 ;i<1000;i++){
			 System.out.println("t1    "+i);
		 }
		});
		//设置优先级 10 最有限 1 最不优先  不设置默认5。 t1.setDaemon(true); 代表是守护线程。其他线程走玩。他就被杀死

		t1.setPriority(1);
		t1.start();

		Thread t2 = new Thread(() -> {
			for (int i=0 ;i<1000;i++){
				System.out.println("t2    "+i);
			}
		});
		t2.setPriority(10);
		t2.start();
	}
}
