package com.google.demoForIdea.common;

public class 睡眠排序 implements Runnable{

		private int num;
		public 睡眠排序(int num){
			this.num=num;
		}
		public static void main(String[] args) {
			int[] nums={1,244,22,11,555};
			for (int i = 0; i < nums.length; i++) {
				new Thread(new 睡眠排序(nums[i])).start();
			}
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(num);
				System.out.println(num);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}


}
