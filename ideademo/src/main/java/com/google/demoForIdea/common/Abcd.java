package com.google.demoForIdea.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Abcd {
	public static void main(String[] args) {
		String text = "A,CK,JHFKDGDKFGXAAAAA";
		String repStr="";
		if(text.contains(",")){
			 repStr = text.replaceAll(",","");
		}
		System.out.println(repStr);
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < repStr.length(); i++) {
			char cc = repStr.charAt(i);
			if (!map.containsKey(cc)) {
				map.put(cc, 1);
			} else {
				int count = map.get(cc);
				map.replace(cc, count + 1);
			}
		}
		Set<Map.Entry<Character, Integer>> entries = map.entrySet();
		for (Map.Entry<Character, Integer> entry : entries) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
