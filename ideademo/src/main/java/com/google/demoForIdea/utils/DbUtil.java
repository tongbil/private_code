package com.google.demoForIdea.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class DbUtil {
	public static void main(String[] args) throws IOException {
		String json = "{\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
		ObjectMapper mapper=new ObjectMapper();
		JsonNode node=mapper.readTree(json);
		System.out.println(node.get("skills"));
		System.out.println(node.get("skills").size());
		System.out.println(node.get("skills").get(1));
		for(int i = 1;i<=4;i++){
			System.out.println(  Character.toUpperCase( (char)(96+i))  );//大写
		}

	}
}
