package com.google.demoForIdea.common;

import com.alibaba.fastjson.JSON;
import com.google.demoForIdea.model.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 数组互转LIST {
	public static void main(String[] args) throws Exception {
		String str ="2,4,5,6,7,8,8";
		String[] split = str.split(",");
		//数组转集合
		List<String> strings = Arrays.asList(split);
		System.out.println(strings);
		//集合转数组
		String[] strings1 = strings.toArray(new String[]{});
		System.out.println(strings1[0]);
		//map转json
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("username","汤彪");
		System.out.println(	JSON.toJSONString(hashMap));
		//map转object.user为具体谁的class
		Object o = mapToObject(hashMap, User.class);
		System.out.println(o.toString());
		//object转实体类
		System.out.println((User)o);
		//object转Map
		System.out.println(objectToMap(o).get("username"));



	}
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
		if (map == null){
			return null;
		}


		Object obj = beanClass.newInstance();

		org.apache.commons.beanutils.BeanUtils.populate(obj, map);

		return obj;
	}
	public static Map<?, ?> objectToMap(Object obj) {
		if(obj == null){
			return null;
		}


		return new org.apache.commons.beanutils.BeanMap(obj);
	}


}
