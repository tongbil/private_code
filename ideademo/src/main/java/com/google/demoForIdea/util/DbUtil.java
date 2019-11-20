package com.google.demoForIdea.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class DbUtil {
	public static void main(String[] args) throws IOException {
		String json = "{\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
		ObjectMapper mapper=new ObjectMapper();
		JsonNode node=mapper.readTree(json);
		System.out.println(node.get("skills"));
	}
}
