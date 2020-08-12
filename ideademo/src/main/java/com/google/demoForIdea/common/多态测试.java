package com.google.demoForIdea.common;

public class 多态测试 {
	public static void main(String[] args) {
		多态 duotai = new 多态();
		多态 duotai2 = new 多态子类();
		多态子类 duotai3 = new 多态子类();

		System.out.println(duotai.k11());
		System.out.println(duotai2.k11());
		System.out.println(duotai3.k11());
	}
}
