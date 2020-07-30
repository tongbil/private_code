package com.google.demoForIdea.controller;

import com.google.demoForIdea.dao.Duoshujuyuan2Dao;
import com.google.demoForIdea.dao.DuoshujuyuanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/duoshujuyuan")
public class DuoshujuyuanConroller {
	@Autowired
	DuoshujuyuanDao duoshujuyuanService;
	@Autowired
	Duoshujuyuan2Dao duoshujuyuan2Service;

	@GetMapping("/duoshujuyuan")
	public void duoshujuyuan()  {
		Map<String, Object> map = new HashMap<>();
		List<Map> test1 = duoshujuyuanService.selectByOddUserId(map);
        List<Map> test2= duoshujuyuan2Service.selectByEvenUserId(map);
		System.out.println(test1);
		System.out.println(test2);
	}
}
