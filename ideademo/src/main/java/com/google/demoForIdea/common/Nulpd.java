package com.google.demoForIdea.common;

import java.util.HashMap;
import java.util.Map;

public class Nulpd {

	public static void main(String[] args) {
		Map<String, Object> maps = new HashMap<>();
		maps.put("cc",null);
		maps.put("rrrr","");
		maps.put("ooo","null");
	    if(isEmpty.filterObject(maps,"cc")){
		    System.out.println("cc");
	    }
		if(isEmpty.filterObject(maps,"rrrr")){
			System.out.println("rrrr");
		}
		if(isEmpty.filterObject(maps,"ooo")){
			System.out.println("ooo");
		}
	}

}
