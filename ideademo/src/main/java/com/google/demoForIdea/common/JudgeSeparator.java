package com.google.demoForIdea.common;

public class JudgeSeparator {
	public static void main (String args[]) {
		String str2 = "718466_1";

		String afterSplit2[] = str2.split("_");
		System.out.println(afterSplit2[0]);
		System.out.println(afterSplit2[1]);

		String str = "1,2,3,,,";
		// 分割之后的字符串
		String afterSplit[] = str.split(",");
		// 分隔符后空内容个数
		int noContent = 0;
		noContent = hasContent(str);
		for (int i = 0; i < afterSplit.length;  i ++){
			System.out.println(afterSplit[i]);
		}
		// noContent小于0说明分隔符后全部有内容
		if (noContent >= 0) {
			for (int j = 0; j <= noContent; j++) {
				System.out.println("null");
			}
		}
	}
	// 比较分隔符个数和split()方法获取内容的长度，若差值大于等于0则表示分隔符后有内容，不能忽略。
	public static int hasContent(String str) {
		// 拆分字符串
		char tmp = ' ';
		// 分隔符个数
		int count = 0;
		// 无内容的分隔符个数
		int diff = 0;
		for (int i = 0; i < str.length();  i ++) {
			tmp = str.charAt(i);
			if (tmp==',') {
				count = count + 1;
			}
		}
		diff = count - str.split(",").length;
		return diff;
	}

}
