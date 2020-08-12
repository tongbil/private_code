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
		String[] geweek = geweek(0, "2020-08-12");
		for (String week:geweek){
			System.out.println(week);
		}
	}
	//0为本周，1为下一周，-1为上一周
	public static String[] geweek(int n,String mydate)  {
		String[] date = new String[7];
	    try {
		    Calendar calendar = Calendar.getInstance();
		    calendar.setFirstDayOfWeek(Calendar.MONDAY);
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    SimpleDateFormat endsdf = new SimpleDateFormat("MMdd");
		    Calendar cal = Calendar.getInstance();
		    Date time = sdf.parse(mydate);
		    cal.setTime(time);
		    int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		    if(1 == dayWeek){
		    	cal.add(Calendar.DAY_OF_MONTH,-1);
		    }
		    cal.setFirstDayOfWeek(Calendar.MONDAY);
		    int day =cal.get(Calendar.DAY_OF_WEEK);
		    cal.add(Calendar.DATE,(cal.getFirstDayOfWeek()-day + 7 * n));
		    date[0]=endsdf.format(cal.getTime());
		    for (int i=1;i<7;i++){
		    	cal.add(Calendar.DATE,1);
		    	date[i]=endsdf.format(cal.getTime());
		    }
	    }catch (Exception e){
	    	e.printStackTrace();
	    	throw new RuntimeException();
	    }

	    return date;
	}
}
