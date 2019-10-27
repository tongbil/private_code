package com.qixin.common;

public class Democest {
	public static void main(String[] args) {
		int[] arr = new int[] {2,1,9,3,7,5,0};
		int[] index = new int[] {1,4,5,1,0,5,6,0,4,3,2};
		String tel = "";
		for (int i : index) {
		tel += arr[i];
		}
		System.out.println("联系方式:"+tel);
	}
}
