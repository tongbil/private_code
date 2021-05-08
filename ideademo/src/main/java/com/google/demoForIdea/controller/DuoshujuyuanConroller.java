package com.google.demoForIdea.controller;

import com.google.demoForIdea.dao.Duoshujuyuan2Dao;
import com.google.demoForIdea.dao.DuoshujuyuanDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping(value = "/duoshujuyuan")
public class DuoshujuyuanConroller {
	@Autowired
	DuoshujuyuanDao duoshujuyuanService;
	@Autowired
	Duoshujuyuan2Dao duoshujuyuan2Service;


	@GetMapping("/dusql")
	public void dusql()  {
String sql = "select * from sys_user where 1=1 <if test=\"usertype != null\">usertype = #{usertype}</if>";
		Map<String, Object> map = new HashMap<>();
		List<Map> dusql_map = duoshujuyuanService.dusql(map);

		String  read_sql = dusql_map.get(0).get("out_sql").toString();
		System.out.println(read_sql);

	}


	@GetMapping("/duoshujuyuan")
	public void duoshujuyuan()  {
		log.trace("trace查询了学生信息");
		log.info("info查询了学生信息");
		log.warn("warn查询了学生信息");
		log.error("erro查询了学生信息");
		log.debug("debug查询了学生信息");
		Map<String, Object> map = new HashMap<>();
		//List<Map> test1 = duoshujuyuanService.selectByOddUserId(map);
      //  List<Map> test2= duoshujuyuan2Service.selectByEvenUserId(map);
	//	System.out.println(test1);
	//	System.out.println(test2);
	}
}
