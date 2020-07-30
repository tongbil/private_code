package com.google.demoForIdea.common;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class 一周的天数 {
	public static void main(String[] args) {

		String[] getweek = getweek(0, LocalDate.now().toString());
		for (String s :getweek){
			System.out.println(s);
		};
	}
	public static String[] getweek(int n, String mydata) {

		String[] date = new String[7];
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setFirstDayOfWeek(Calendar.MONDAY);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
			SimpleDateFormat endsdf = new SimpleDateFormat("MMdd");
			Calendar cal = Calendar.getInstance();
			Date time = sdf.parse(mydata);
			cal.setTime(time);

			//判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
			int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
			if (1 == dayWeek) {
				cal.add(Calendar.DAY_OF_MONTH, -1);
			}
			//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
			cal.setFirstDayOfWeek(Calendar.MONDAY);
			//获得当前日期是一个星期的第几天
			int day = cal.get(Calendar.DAY_OF_WEEK);
			//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
			cal.add(Calendar.DATE, (cal.getFirstDayOfWeek() - day + 7 * n));
			date[0] = endsdf.format(cal.getTime());
			for (int i = 1; i < 7; i++) {
				cal.add(Calendar.DATE, 1);
				date[i] = endsdf.format(cal.getTime());
			}

		} catch (Exception e) {
			e.printStackTrace();

			throw new RuntimeException(e);
		}

		return date;
	}
}
