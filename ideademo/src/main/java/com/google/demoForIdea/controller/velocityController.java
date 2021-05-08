package com.google.demoForIdea.controller;

import com.google.demoForIdea.dao.VelocityDao;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/velocity")
public class velocityController {
	@Autowired
	private VelocityDao velocityDao;

	@GetMapping("/dusql")
	public Map dusql() throws IOException {
		Map<String, Object> map = new HashMap<>();
		map.put("id","1");
		map.put("box","2");
		String[] ids =new String[]{"1","2","3"};

		String[] kkk =new String[]{"1","2"};


		map.put("ids",ids);
		map.put("kk",kkk);
	//	String read_sql = "select * from sys_user where 1=1 and UserID = '$id' #if($box and $box!='') and box = '$box' #end ";
		//String read_sql ="update table set ab='$id' where 1=1";
		//String read_sql="insert all #foreach($map in $list) into table values('$map.id') #end select 1 from dual";
		String read_sql="select * from table where  id in (#foreach($da in $ids) $da   #if($foreach.count!=$ids.size()), #end #end) and kk in ( #foreach($k in $kk)$k #if($foreach.count != $kk.size()), #end #end)";
		map.put("read_sql",read_sql);
		VelocityEngine ve = new VelocityEngine();
		ve.init();
		VelocityContext content = new VelocityContext(map);
		StringWriter writer = new StringWriter();
		ve.evaluate(content,writer,"",read_sql);
		read_sql=writer.toString();
		map.put("read_sql",read_sql);
		map.put("shuju",velocityDao.do_sql(map));
		File file = new File("C:\\Users\\tangcomes\\Desktop\\markdown\\read_sql.sql");
		file.createNewFile();
		writeFile(file,read_sql);
		return map;
	}
	//写文件
	public static void writeFile(File file, String content) {
		try (FileWriter writer = new FileWriter(file); BufferedWriter out = new BufferedWriter(writer)) {
			out.write(content);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
