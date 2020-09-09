package com.google.demoForIdea.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 时间加1小时 {
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		Date date2=null;
		try {
			date2=	sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar ca=Calendar.getInstance();
		Calendar ca2=Calendar.getInstance();
		ca.setTime(date2);
		ca2.setTime(date2);
		ca.add(Calendar.HOUR_OF_DAY, 1);
		ca2.add(Calendar.HOUR_OF_DAY, 2);
		System.out.println(sdf.format(ca.getTime()));
		System.out.println(sdf.format(ca2.getTime()));

		String format = sdf.format(new Date());
		System.out.println(format);
		StringBuilder sub = new StringBuilder(format);
		sub.replace(14,19,"00:00");
		System.out.println(sub);
	}
}
