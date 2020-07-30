package com.google.demoForIdea.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 日期加一年 {
	public static void main(String[] args) throws ParseException {
		String date ="2020-06-30";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now_date = sdf.parse(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(now_date);//设置起时间
		cal.add(Calendar.YEAR, 1);//增加一年
		System.out.println("输出::"+sdf.format(cal.getTime()));
	}
}
