package com.qixin.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class SpringContext implements ApplicationContextAware {

	public static Object getBeanBySpring(String name){
		WebApplicationContext ac = ContextLoader.getCurrentWebApplicationContext();
		return ac.getBean(name);
	}
	public static Object getBeanByClass(Class clazz){
		WebApplicationContext ac = ContextLoader.getCurrentWebApplicationContext();
		return ac.getBean(clazz);
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0)throws BeansException {
		
	}
	
}
