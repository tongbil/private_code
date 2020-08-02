package com.google.demoForIdea.controller;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.NumbericRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.google.demoForIdea.common.JxlsUtil;
import com.google.demoForIdea.common.ZipUtils;
import com.google.demoForIdea.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/people_context")
public class personController {
	private static final String DISTRIBUTED_SESSION_ID = "JSESSIONID";
	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpServletResponse resp;
	boolean flag=false;
	//@CrossOrigin 类上加跨域
	@Autowired
	private PersonDao personService;
	@ResponseBody
	//用try 必须自定义throw     NullPointerException("不存在!");
	@Transactional(rollbackFor = Exception.class)
	@GetMapping("/edit_message")
	public String edit_message() {
		flag=!flag;
		System.out.println(flag);
	/*	Map<String, String> map = new HashMap<>();
		map.put("email","我是email");
		map.put("content_message","我是message");

		personService.insert_edit_message(map);

		try {
			int isp =2/0;
		}catch (Exception e){
			e.printStackTrace();

			throw  new  NullPointerException("不存在!");
		}
*/


		return "";
	}


	@ResponseBody
	@PostMapping("/cookie_bak")
	public Cookie cookie_bak(@RequestBody Map<String, String> map) {
		/*try{
			if(	personService.insert_edit_message(map)>=1){
				map.put("result","success");
			}
		}catch (Exception e){
			map.put("result","提交失败");
		}*/
		Cookie[] cookies = req.getCookies();
		System.out.println(cookies);
		if(null!=cookies){
			for (int i = 0, n = cookies.length; i < n; i++) {
				if (cookies[i].getName().equalsIgnoreCase(DISTRIBUTED_SESSION_ID)) {
					System.out.println(cookies[i]);

				}
			}
		}

		map.put("result","我是window系统");
		HttpSession session = req.getSession();
		System.out.println(session.getId());
		Cookie cookie = new Cookie(DISTRIBUTED_SESSION_ID, session.getId());
		resp.addCookie(cookie);
		return cookie;
	}

	//4.0.0填充docx
	@GetMapping("/edit_message_bak")
	public void edit_message_bak(HttpServletResponse resp) throws IOException {
		Map<Object, Object> map = new HashMap<>();


		map.put("add","222222");
		map.put("arr",new NumbericRenderData(new ArrayList<TextRenderData>(){{
			add(new TextRenderData("000000", "2013年 以《剧场女神》公演正式出道"));
			add(new TextRenderData("000000", "2014年 拍摄个人首支MV《足球派对》"));
		}}));

		Map<Object, Object> map2 = new HashMap<>();
		Map<Object, Object> map3 = new HashMap<>();
		map2.put("name","Memories");
		map3.put("name","Last Dance(伍佰)");
		List<Map> arrlist= new ArrayList<>();
		arrlist.add(map2);
		arrlist.add(map3);
		map.put("songs",arrlist);

		//一行代码 poi4.0.0版本
		XWPFTemplate template =
				XWPFTemplate.compile("C:\\Users\\tangcomes\\Desktop\\template.docx").render(map);
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

