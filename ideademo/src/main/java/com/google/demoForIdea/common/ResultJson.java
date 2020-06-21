package com.google.demoForIdea.common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class ResultJson {
	public static void main(String[] args) {
		Gson gson = new Gson();
		String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
		String[] strings = gson.fromJson(jsonArray, String[].class);
		System.out.println(strings[1]);

		//
		Gson gson1 = new Gson();
		String jsonArray1 = "[\"Android\",\"Java\",\"PHP\"]";
		List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {}.getType());
		//Map<String, String> map = gson.fromJson(rebate, new TypeToken<Map<String, String>>() {}.getType());
		System.out.println(stringList);




	}
}
