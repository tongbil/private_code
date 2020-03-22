package com.google.demoForIdea.common;

import java.util.Arrays;
import java.util.List;

public class StringList {
	public static void main(String[] args) {
		//字符串转list<String>
		String str = "ABCD";
		List<String> lis = Arrays.asList(str.split(""));
		System.out.println(lis);
		for (String string : lis) {
			System.out.println(string);
		}
		//list<String>转字符串
		System.out.println(String.join("", lis));
	}
}
