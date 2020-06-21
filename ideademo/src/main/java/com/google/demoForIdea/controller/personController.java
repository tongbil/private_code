package com.google.demoForIdea.controller;

import com.deepoove.poi.XWPFTemplate;
import com.google.demoForIdea.common.JxlsUtil;
import com.google.demoForIdea.common.ZipUtils;
import com.google.demoForIdea.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping(value = "/people_context")
public class personController {
	@Autowired
	private PersonService personService;

	@ResponseBody
	@PostMapping("/edit_message")
	public Map edit_message(@RequestBody Map<String, String> map) {
		try{
			if(	personService.insert_edit_message(map)>=1){
				map.put("result","success");
			}
		}catch (Exception e){
			map.put("result","提交失败");
		}

		return map;
	}

	//4.0.0填充docx
	@GetMapping("/edit_message_bak")
	public void edit_message_bak(HttpServletResponse resp) throws IOException {
		//一行代码 poi4.0.0版本
		XWPFTemplate template = XWPFTemplate.compile("C:\\Users\\tangcomes\\Desktop\\template.docx").render(new HashMap(){
			{
			put("add", "Poi-tl 模板引擎");

		}


		});



		//template.writeToFile("C:\\Users\\tangcomes\\Desktop\\out_template.docx");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/msword");
		resp.setHeader("Content-Disposition", "attachment;filename="
				.concat(String.valueOf(URLEncoder.encode("out_template.docx", "UTF-8"))));
		/*ThreadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					testDocx(resp);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});*/
		OutputStream out =resp.getOutputStream();
		template.write(out);
		out.flush();
	}
	//zip
	@GetMapping("/zip_bak")
	public void zip_bak(HttpServletResponse resp) throws IOException {
		String targetFolderPath = "C:\\Users\\tangcomes\\Desktop\\testZip";
		String rawZipFilePath = "C:\\Users\\tangcomes\\Desktop\\testZip.zip";
		String newZipFilePath = "C:\\Users\\tangcomes\\Desktop\\testZip.zip";
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/zip");
		resp.setHeader("Content-Disposition", "attachment; filename=excel.zip");
		OutputStream out =resp.getOutputStream();

		ZipUtils.compress(targetFolderPath , targetFolderPath,out);

	}
	@GetMapping("/execl_bak")
	public void execl_bak(HttpServletResponse resp) throws IOException {
		Map<String,Object> model = new HashMap<>();
		Map<String,Object> map = new HashMap<>();
		map.put("id","我是id");
		model.put("title","我是标题");
		model.put("titles","我是标题s");
		Map<String,Object> map2 = new HashMap<>();
		map2.put("test","tang");
		map2.put("test1","biao");
		Map<String,Object> map3 = new HashMap<>();
		map3.put("test","tang");
		map3.put("test1","biao");
		List<Map> maps= new ArrayList<>();
		maps.add(map2);
		maps.add(map3);
		model.put("dataList",maps);
		//model.put("dataMap",new ArrayList<Map<String,Object>>());
		model.put("map",map);
		try {
			InputStream is = JxlsUtil.class.getResourceAsStream("/excel/tangbiao.xlsx");
			OutputStream os = new FileOutputStream("C:\\Users\\tangcomes\\Desktop\\tangbiao.xlsx");
			//OutputStream os=resp.getOutputStream();

			JxlsUtil.export2Excel(is,os,model);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

