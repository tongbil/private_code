package com.google.demoForIdea.common;

import com.google.demoForIdea.model.User;

import java.util.HashMap;
import java.util.Map;

public class object互转map {
	public static void main(String[] args) throws Exception {

		User  o =new User();
		o.setUsername("2222");
		Object obj =o;
		Map<String, Object> map = new HashMap<>();

		map.put("id","22");
		Object o1 = mapToObject(map, obj.getClass());
		System.out.println(o1.getClass().getName());


		Map map1 = objectToMap(obj);
		System.out.println(map1.get("username"));
	}
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
		if (map == null)
			return null;

		Object obj = beanClass.newInstance();
		org.apache.commons.beanutils.BeanUtils.populate(obj, map);
		return obj;
	}

	public static Map<?, ?> objectToMap(Object obj) {
		if (obj == null)
			return null;
		return new org.apache.commons.beanutils.BeanMap(obj);
	}

}
