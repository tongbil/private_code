package com.google.demoForIdea.controller;

import com.google.demoForIdea.service.XcxService;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

	@Autowired
	@Qualifier("singleRedisson")
	private RedissonClient redissonClient;

	@ResponseBody
	@GetMapping("/lunbo")
	public Map selectlunbo() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("banners", xcxService.selectbo(map));
		return map;
	}

	@GetMapping("/redis")
	public void redis() {
		RBucket<String> key = redissonClient.getBucket("newday");
		key.set("新的数据1111111111");
		System.out.println("获取到新存入的数据："+key.get());
		// 获取字符串格式的数据
		RBucket<String> keyObj = redissonClient.getBucket("newday");
		String s = keyObj.get();
		System.out.println("获取到昨天存入的数据："+s);
	}
}

