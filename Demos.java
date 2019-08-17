package com.qixin.common;



public class Demos implements Runnable{
	private String num;
	public Demos(int num){
		this.num=num+"";
	}
		public static void main(String[] args) {
			int[] nums={1,244,22,11,555};
			for (int i = 0; i < nums.length; i++) {
				new Thread(new Demos(nums[i])).start();
			}
		}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 try {
			Thread.sleep(Integer.parseInt(num));
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

