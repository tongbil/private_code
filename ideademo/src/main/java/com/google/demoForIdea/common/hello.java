package com.google.demoForIdea.common;

public class hello {
	public static void main(String[] args){

		hello hello = new hello();
		Integer test = hello.test(1);
		String test1 = hello.test("2");

	}

	public <T> T test(T a){
		System.out.println(a);
		return a;
	}
	public String te(){
		return "";
	}
}
