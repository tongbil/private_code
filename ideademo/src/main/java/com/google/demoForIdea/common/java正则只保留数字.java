package com.google.demoForIdea.common;

import java.util.regex.Pattern;

public class java正则只保留数字 {
	public static void main(String[] args) {
		String  ticketStr= " 718.04 ";
		String REGEX = "[^(0-9)]";
		String ticket = Pattern.compile(REGEX).matcher(ticketStr).replaceAll("").trim();
		System.out.println(ticket);
	}

}
