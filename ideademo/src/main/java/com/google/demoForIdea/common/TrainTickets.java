package com.google.demoForIdea.common;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrainTickets implements Runnable{
  volatile 	int  ticketnum = 20;
	Lock lock = new ReentrantLock();
	public void run(){
		boolean a = true;
		while (a) {
			lock.lock();// 获取锁对象
		//	System.out.println(	lock.tryLock());
				if (ticketnum > 0) {
					System.out.println(Thread.currentThread().getName() + " 售出  " + ticketnum + "号 票。");
					ticketnum--;
				} else if (ticketnum <= 0) {
					a = false;
				}
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					lock.unlock();// 释放锁对象
				}
			}

	}

	public static void main(String[] args) {
		TrainTickets t = new TrainTickets();
		Thread t1 = new Thread(t,"窗口1");
		Thread t2 = new Thread(t,"窗口2");
		t1.start();
		t2.start();
;
	}
}
