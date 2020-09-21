package com.google.demoForIdea.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JDKNull {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		map.put("abc","abc");
		String obj = (String) Optional.ofNullable(map)
				.flatMap(t -> Optional.ofNullable(map.get("abc"))).orElse("返回");

	}


}
