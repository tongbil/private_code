package com.google.demoForIdea.common;

import com.github.pagehelper.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class Nulpd {

	public static void main(String[] args) {
		Map<String, String> maps = new HashMap<>();
		  //map的value必须是string类型才为true.不能为object
		 boolean ff = StringUtil.isEmpty(maps.get("cc"));
		System.out.println(ff);
	}

}
