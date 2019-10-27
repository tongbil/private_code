package com.qixin.common;



import java.text.SimpleDateFormat;
import java.util.Date;
public class ls {
    public static void main(String[] args) throws Exception{
    			Date date = new Date();
    		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		 String format = simpleDateFormat.format(date);
    		 Date parse = simpleDateFormat.parse(format);
    		 System.out.println(parse);
    	//	String afterJson="{"result":"","resume":"","label":"","items":[{"filedName":"sex","name":"性别","id":1,"status":1},{"filedName":"age","name":"年龄","id":2,"status":1},{"filedName":"effectTime","name":"不良反应发生时间","id":3,"status":1}]}";
      	
    }


}
