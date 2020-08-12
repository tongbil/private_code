package com.google.demoForIdea.common;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存工具类
 */
public class EasyCacheUtil {
	/*缓存map*/
	private static Map<String,Object> cacheMap = new ConcurrentHashMap<>();
	/*缓存有效期map*/
	private static Map<String,Long> expireMap = new ConcurrentHashMap<>();


	/**
	 * 通过key获取值
	 * @param key
	 * @param <T>
	 * @return
	 */
	public static <T> T get(String key){
		if(!cacheMap.containsKey(key)){
			return null;
		}
		if(expireMap.containsKey(key)){
			if(expireMap.get(key)<System.currentTimeMillis()){
				return null;
			}
		}
		Object obj = cacheMap.get(key);
		return obj == null ? null : (T)obj;

	}

	/**
	 * 设置不过期的值
	 * @param key
	 * @param value
	 */
	public static void set(String key, Object value){
		cacheMap.put(key, value);
	}

	/**
	 * 设置过期的值
	 * @param key
	 * @param value
	 * @param ms 毫秒
	 */
	public static void set(final String key, Object value,int ms){
		System.out.println(System.currentTimeMillis());
		final long expire = System.currentTimeMillis() + ms;
		System.out.println(expire);
		cacheMap.put(key,value);
		expireMap.put(key,expire);
		// 清除过期数据
		if(cacheMap.size() > 2){
			new Thread(new Runnable() {
				public void run() {
					Iterator<Map.Entry<String,Object>> iterator = cacheMap.entrySet().iterator();
					while (iterator.hasNext()){
						Map.Entry<String,Object> entry = iterator.next();
						if(expireMap.containsKey(entry.getKey())){
							long expireTime = expireMap.get(key);
							if(System.currentTimeMillis() > expireTime){
								iterator.remove();
								expireMap.remove(entry.getKey());
							}
						}
					}
				}
			}).start();
		}
	}

	/**
	 * 通过key删除值
	 * @param key
	 */
	public static void del(String key){
		if(cacheMap.containsKey(key)){
			cacheMap.remove(key);
		}
		if(expireMap.containsKey(key)){
			expireMap.remove(key);
		}
	}

	/**
	 * 判断key是否存在
	 * @param key
	 */
	public static boolean isExist(String key){
		return cacheMap.containsKey(key);
	}

	public static void main(String[] args) {
		//EasyCacheUtil.set("myname","汤彪");
		//String myname = EasyCacheUtil.get("myname").toString();
	//	System.out.println(myname);
		EasyCacheUtil.set("myname_guoqi","汤彪过期",10);
		for (int i=0;i<10000;i++){
			if(EasyCacheUtil.isExist("myname_guoqi")){
				System.out.println(EasyCacheUtil.get("myname_guoqi").toString()+""+i);
				if(null==EasyCacheUtil.get("myname_guoqi")){
					System.out.println("存在。但是过期了");

					break;
				}
			}else{
				System.out.println(i+"已经不存在");
			}
		}
	}
}