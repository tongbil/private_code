package com.google.demoForIdea.controller;

import com.google.demoForIdea.service.XcxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;
@RestController
@RequestMapping(value = "/xcx")
public class xcxController {
	@Autowired
	private XcxService xcxService;

	@ResponseBody
	@GetMapping("/lunbo")
	public Map selectlunbo() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("banners",xcxService.selectbo(map));
			return map;
		}
}

