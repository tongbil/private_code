package com.google.demoForIdea.common;

import java.io.File;

public class 删除文件 {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\tangcomes\\Desktop\\dse");
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		File[] files = file.listFiles();
		for (File file_one:files){
			File file1 = new File(file_one.getAbsolutePath());
			file1.delete();
		}
		file.delete();
	}
}
