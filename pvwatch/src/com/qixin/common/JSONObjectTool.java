package com.qixin.common;

import net.sf.json.JSONObject;

public class JSONObjectTool {
	/**
	 * 获取json数据,返回结果
	 * 
	 * @throws Exception
	 */
	public static String getJson(Object object) throws Exception {
		String temp = JSONObject.fromObject(object).toString();
		return temp;
	}
}
