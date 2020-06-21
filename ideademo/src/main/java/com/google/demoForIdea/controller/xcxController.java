package com.google.demoForIdea.controller;

import com.google.demoForIdea.service.CpxmService;
import com.google.demoForIdea.service.XcxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/xcx")
public class xcxController {
	@Autowired
	private XcxService xcxService;
	@Autowired
	private CpxmService cpxmService;

	@ResponseBody
	@GetMapping("/lunbo")
	public Map selectlunbo() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("banners", xcxService.selectbo(map));
		return map;
	}
	@ResponseBody
	@GetMapping("/person")
	public Map person() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id","2");
		try {
			cpxmService.person(map);
		}catch (Exception e){
			int i =1;
		};
			int b =1;
			int c =1;

		return map;
	}

}

