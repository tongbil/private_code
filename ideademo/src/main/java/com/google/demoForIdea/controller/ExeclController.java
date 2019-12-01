package com.google.demoForIdea.controller;

import com.google.demoForIdea.common.ParseExcel;
import com.google.demoForIdea.service.ExeclService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/execl")
public class ExeclController {
	@Autowired
	ExeclService execlService;
	@PostMapping("/importAlumnis")
	@ResponseBody
	public Map importAlumnis(@RequestParam(value = "alumniData") MultipartFile file) throws IOException {
		Map<String, Object> map = new HashMap<>();
		InputStream inputStream=null;
		try {
			//输入流
;			inputStream = file.getInputStream();
			//原始文件名
			String originalFilename = file.getOriginalFilename();
			//文件后缀
			String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			ParseExcel parser = new ParseExcel();
			//第er行开始读取
			int startRow = 1;
			List<String[]> result = parser.parseExcel(inputStream, suffix, startRow);

			int count=0;
			for(String[] ss : result){
				// System.out.println(Arrays.toString(ss));
				map.put("username",ss[0]);
				map.put("phone",ss[1]);
				map.put("openid",ss[2]);
				map.put("zhuohao",ss[3]);
				map.put("renshu",ss[4]);
				map.put("create_time",ss[5]);
				map.put("update_time",ss[6]);
				int i = execlService.inserExecl(map);
				if(i==1){
					count++;
				}
			}
			if(count==result.size()){
				//全部数据导入成功
				return (Map) map.put("reuslt","全部数据导入成功");
			}
			return (Map) map.put("reuslt","部分数据导入成功");

		} catch (IOException e) {
			e.printStackTrace();
			return (Map) map.put("reuslt","导入数据失败");
		} finally {
			//关闭流
			inputStream.close();
		}
	}
}
