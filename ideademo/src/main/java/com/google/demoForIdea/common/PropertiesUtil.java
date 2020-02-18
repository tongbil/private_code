package com.google.demoForIdea.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author shusheng
 *
 */
public class PropertiesUtil {
	private static Properties prop = null;
	
	private static void getPropInstance(){
		if(prop==null){
			prop = new Properties();
		}
	}
	public static String readProperty(String key){
		try {
			getPropInstance();
			InputStream inputStream = PropertiesUtil.class.getResourceAsStream("/conf.properties");
			prop.load(inputStream);
			return prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
