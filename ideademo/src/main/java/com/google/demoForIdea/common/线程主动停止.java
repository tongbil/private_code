package com.google.demoForIdea.common;

public class 线程主动停止 {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			while (true){
				try {
					//Thread.sleep(500);
					//获取执行这段代码的当前线程的状态
					boolean interrupted = Thread.currentThread().isInterrupted();
					if(interrupted){
						//很优雅的停止
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("线程执行中");
			}
		});

	//	boolean interrupted = t1.isInterrupted();
	//	System.out.println(interrupted);

		System.out.println(	t1.getId());
		System.out.println(	t1.getName());
		System.out.println(	t1.getState()+":获取");

		t1.start();
		//获取线程状态
		Thread.State state1 = t1.getState();
		System.out.println(state1+"获取?");
		System.out.println(t1.isInterrupted());
		try {
			Thread.sleep(100);

			//主动停止
			t1.interrupt();
			System.out.println(t1.isInterrupted());
			System.out.println(t1.getState()+"获取！");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	};


}
