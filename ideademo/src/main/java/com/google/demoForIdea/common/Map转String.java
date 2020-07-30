package com.google.demoForIdea.common;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Map转String {
	/**
	 * name : 名字
	 * id : 2222
	 */

	private String name;
	private String id;

	public static void main(String[] args) {
		Map<Object, Object> test_map = new HashMap<>();
		test_map.put("id","2222");
		test_map.put("name","名字");
		String json = JSONObject.toJSONString(test_map);
		System.out.println(json);
		Gson gson = new Gson();
		Map转String map转String = gson.fromJson(json, Map转String.class);

		System.out.println(	map转String.getName());

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
