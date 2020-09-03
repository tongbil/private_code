package com.google.demoForIdea.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date时间指定格式 {
	public static void main(String[] args) {
		boolean convertSuccess=true;
		String str= "2020-08-11 13:24:00";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setLenient(false);
		try {
			format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			convertSuccess=false;
		}
		System.out.println(convertSuccess);
		String s = str.replaceAll("\\s*", "");
		System.out.println(s.length());

		//查询三天后
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		System.out.println("当前日期:"+sf.format(c.getTime()));
		c.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println("增加一天后日期:"+sf.format(c.getTime()));


	}



}
