package com.google.demoForIdea.controller;

import com.google.demoForIdea.service.XcxService;
import com.google.demoForIdea.threadTool.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/xcx")
public class xcxController {
	@Autowired
	private XcxService xcxService;

	@ResponseBody
	@GetMapping("/lunbo")
	@Log
	public Map selectlunbo() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("banners", xcxService.selectbo(map));
		return map;
	}
}

