package com.google.demoForIdea.common;

public class StringUtil {

	public static String isNull(String value) {
		String result = "";
		if (null == value) {
			result = "true";
			return result;
		}
		if("".equals(value)){
			result = "true";
			return result;
		}
		if("undefined".equals(value)){
			result = "true";
			return result;
		}
		return result;
	}


}
