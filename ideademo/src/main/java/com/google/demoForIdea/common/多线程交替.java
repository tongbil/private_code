package com.google.demoForIdea.common;

public class 多线程交替 {
	public static void main(String[] args) {
		NumMode numMode = new NumMode();
		new Thread(new jiNum(numMode)).start();
		new Thread(new OuNum(numMode)).start();
	}

	static class jiNum implements Runnable {
		private NumMode numMode;

		public jiNum(NumMode numMode) {
			this.numMode = numMode;

		}

		@Override
		public void run() {

			while (true) {
				synchronized (numMode) {
					if (numMode.num < 100) {
						if (numMode.num % 2 != 0) {

							System.out.println("奇数" + numMode.num);
							numMode.num++;
							numMode.notify();
						} else {
							try {
								numMode.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					} else {
						break;
					}
				}


			}
		}
	}

	static class OuNum implements Runnable {
		private NumMode numMode;

		public OuNum(NumMode numMode) {
			this.numMode = numMode;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (numMode) {
					if (numMode.num < 100) {
						if (numMode.num % 2 == 0) {

							System.out.println("偶数" + numMode.num);
							numMode.num++;
							numMode.notify();
						} else {
							try {
								numMode.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					} else {
						break;
					}
				}


			}
		}
	}

	static class NumMode {
		int num = 1;
	}

}