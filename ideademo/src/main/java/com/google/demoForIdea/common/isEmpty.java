package com.google.demoForIdea.common;

import java.util.Map;

public class isEmpty {

	public final static boolean  filterObject(Map<String,Object> maps, String key) {
		if(null == maps.get(key) || null == maps.get(key).toString() || "".equals(maps.get(key).toString())  ||"null".equals(maps.get(key).toString())
		||"undefined".equals(maps.get(key).toString()) || "".equals(maps.get(key).toString().trim())){
			return false;
		}
		return true;
	}

}
