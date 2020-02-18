package com.google.demoForIdea.common;


import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FilePd {
	public static final String BASE_PATH = "/file/";
	public static void main(String[] args) {
		Map<String, Object> params = new HashMap<String, Object>();
		String uploadFileResult = HttpClient.doPost("/fileManager/uploadFile.htm", null, params,
				"multipart/form-Data");
		String uuid =  UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
		File file=	new File("C:\\Users\\tangcomes\\Desktop\\27console.txt");
		//获取上一层的路径
		System.out.println(file.getParentFile());
		//获取文件的大小
		System.out.println(file.length());
		//获取文件名字
		System.out.println(file.getName());
		//判断文件是否绝对路径:
		System.out.println(file.isAbsolute());
		//判断文件根目录
		System.out.println(file.getParent());
        //判断文件是否存在
		System.out.println(file.exists());
		//判断是否是目录: file.isDirectory()，
		// 判断是否是文件:  file.isFile()，
		// 判断是否是隐藏文件: file.isHidden()，
		// 判断是否可读:file.canRead()，
		//判断是否可写file.canWrite()。

		//获取文件后缀名 包括 . 符号
		if(file.getName().contains(".")){
			System.out.println( file.getName().substring(file.getName().lastIndexOf(".")));

		}
		System.out.println(file.getParentFile()+""+BASE_PATH);
		System.out.println(uuid+""+file.getName().substring(file.getName().lastIndexOf(".")));
		File targetFile = new File(file.getParentFile()+""+BASE_PATH, uuid+""+file.getName().substring(file.getName().lastIndexOf(".")));
		if(file.isAbsolute()){
			System.out.println("是绝对路径");
		}
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		} else {
			targetFile.delete();
		}
		try {
		//	file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		String accessUrl =  "/"+uuid+""+file.getName().substring(file.getName().lastIndexOf("."));
		System.out.println(accessUrl);

	}
}
