package com.google.demoForIdea.common;

import com.github.pagehelper.util.StringUtil;

import java.util.Map;

public class isEmpty {

	public final static boolean  filterObject(Map<String,Object> maps, String key) {

		if(maps.get(key)==null || "".equals(maps.get(key))  ||"null".equals(maps.get(key)) ){
			return false;
		}
		return true;
	}
	public final static boolean  filterString(Map<String,String> maps, String key) {

		if(maps.get(key)==null || StringUtil.isEmpty(maps.get(key)) ||"null".equals(maps.get(key)) ){
			return false;
		}
		return true;
	}
}
