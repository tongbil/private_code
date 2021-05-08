package com.google.demoForIdea.common;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AA快捷键 {
	public static void main(String[] args) {
		/*ctrl+shift+v 查看 黏贴历史*/
		/*alt+鼠标左键+拖动 可以多行编辑*/
		/*	ctrl+alt+L  格式化空格*/
		/*alt+上下 可移动代码*/
		/*home 跳当前行的行首 end跳行尾*/
		/*alt+左右 跳一个词行首行尾*/
		/*ctrl +shift +左右 复制一个词*/
		/*ctrl +e  浏览历史文件*/
		/*ctrl +s  解析字符串进行GSON*/

		JSONObject obj = new JSONObject();
		obj.put("1","1");
		Map<String, Object> map = new HashMap<>();
		map.put("1","1");
		map.put("2","2");
		System.out.println(obj.toString());
		System.out.println(map.toString());
	}
}
