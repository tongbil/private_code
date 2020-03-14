package com.google.demoForIdea.common;

import com.google.demoForIdea.model.UserDomain;

import java.lang.reflect.Field;
import java.util.Date;

public class tets {
	public static void main(String[] args) throws IllegalAccessException {
		System.out.println(String.valueOf(System.currentTimeMillis()));
		char[] chars = "Ttzhyx".toCharArray();
		chars[0]+=32;
		System.out.println( String.valueOf(chars));


		/*try {
			Class<?> u= UserDomain.class;

			UserDomain user= (UserDomain)u.newInstance();

			Field fs[]=u.getDeclaredFields();
			for (int i = 0; i < fs.length; i++) {
				System.out.println(fs[i]);
			}
		//获取方法
			Method[] method=u.getDeclaredMethods();
			for (int i = 0; i < method.length; i++) {
				System.out.println(method[i]);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e){
			e.printStackTrace();
		}*/
		/*try {
			Class<?> u = Class.forName("com.google.demoForIdea.model.UserDomain");
			//创建对象实例
			UserDomain user = (UserDomain) u.newInstance();

			//获取特定属性值
			Field field=u.getDeclaredField("id");

			field.setAccessible(true);
			field.set(user, 10);
			System.out.println(field.get(user));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}*/
	UserDomain p = new UserDomain();
		// 获取class
		Class c = p.getClass();
		// 获取该类所有的字段
		Field[] fields = c.getDeclaredFields();
		// 遍历赋值
		for (int i = 0; i < fields.length; i++) {
			String filedName = fields[i].getName();
			// AccessibleTest类中的成员变量为private,故必须进行此操作
			fields[i].setAccessible(true);
			// 判断类型
			Class<?> type=fields[i].getType();
			//获取字段类型
			String typeName=type.getName();
			System.out.println(type.getName());

			// 对字段进行赋值 第一个参数为对象引用第二个参数为要附的值

			//如果为字符串类型
			if("java.lang.String".equals(typeName)){
				fields[i].set(p, "1");
			}
			//如果为日期类型
			else if("java.util.Date".equals(typeName)){
				fields[i].set(p, new Date());
			}
			else{
				fields[i].set(p, 1);
			}
			System.out.println(fields[i].get(p));
		}
	}
}
