package com.google.demoForIdea.controller;

import com.google.demoForIdea.common.HttpClient;
import com.google.demoForIdea.common.ParseExcel;
import com.google.demoForIdea.common.PropertiesUtil;
import com.google.demoForIdea.dao.ExeclDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping(value = "/execl")
public class ExeclController {
	public static final String BASE_PATH = "/file/";
	@Autowired
	ExeclDao execlService;

	@PostMapping("/importAlumnis")
	@ResponseBody
	public Map importAlumnis(@RequestParam(value = "alumniData") MultipartFile file) throws IOException {
		Map<String, Object> map = new HashMap<>();
		InputStream inputStream = null;
		try {
			//输入流
			;
			inputStream = file.getInputStream();
			//原始文件名
			String originalFilename = file.getOriginalFilename();
			//文件后缀
			String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			ParseExcel parser = new ParseExcel();
			//第er行开始读取
			int startRow = 1;
			List<String[]> result = parser.parseExcel(inputStream, suffix, startRow);

			int count = 0;
			for (String[] ss : result) {
				// System.out.println(Arrays.toString(ss));
				map.put("username", ss[0]);
				map.put("phone", ss[1]);
				map.put("openid", ss[2]);
				map.put("zhuohao", ss[3]);
				map.put("renshu", ss[4]);
				map.put("create_time", ss[5]);
				map.put("update_time", ss[6]);
				int i = execlService.inserExecl(map);
				if (i == 1) {
					count++;
				}
			}
			if (count == result.size()) {
				//全部数据导入成功
				return (Map) map.put("reuslt", "全部数据导入成功");
			}
			return (Map) map.put("reuslt", "部分数据导入成功");

		} catch (IOException e) {
			e.printStackTrace();
			return (Map) map.put("reuslt", "导入数据失败");
		} finally {
			//关闭流
			inputStream.close();
		}
	}

	@PostMapping("/upload")
	@ResponseBody
	public Map upload(@RequestParam(value = "uptext") MultipartFile file) throws IOException, NoSuchAlgorithmException, KeyManagementException {
		String uuid =  UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
		//获取文件名字
		System.out.println(file.getOriginalFilename());
		//获取文件的大小
		System.out.println(file.getSize());
		//获取文件名字 是uptext
		System.out.println(file.getName());

		//判断是否是目录: file.isDirectory()，
		// 判断是否是文件:  file.isFile()，
		// 判断是否是隐藏文件: file.isHidden()，
		// 判断是否可读:file.canRead()，
		//判断是否可写file.canWrite()。

		//获取文件后缀名 包括 . 符号
		if(file.getOriginalFilename().contains(".")){
			System.out.println( file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));

		}
		//创建新的文件
		File targetFile = new File("C:\\Users\\tangcomes\\Desktop\\"+BASE_PATH, uuid+""+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));

		if (!targetFile.exists()) {
			targetFile.mkdirs();
		} else {
			targetFile.delete();
		}
		try {
			//相当于copy
				file.transferTo(targetFile);
				//调接口
			String fdfsUploadResultss = HttpClient.httpFileUpload(PropertiesUtil.readProperty("fileServer")+"c", targetFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}



		return null;
	}
}
