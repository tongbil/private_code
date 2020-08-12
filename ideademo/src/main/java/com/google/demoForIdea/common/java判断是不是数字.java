package com.google.demoForIdea.common;

public class java判断是不是数字 {

	public static void main(String[] args) {

		boolean flag=isInteger("d2022");
		System.out.println(flag);
	}
	public static boolean isInteger(String str) {
	String reg = "\\d+(\\.\\d+)?";
		return str.matches(reg);
	}
}
