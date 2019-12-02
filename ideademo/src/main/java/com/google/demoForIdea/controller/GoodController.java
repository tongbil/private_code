package com.google.demoForIdea.controller;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.demoForIdea.model.Good;
import com.google.demoForIdea.model.Order;
import com.google.demoForIdea.model.OrderInfo;
import com.google.demoForIdea.service.GoodService;
import com.google.demoForIdea.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/good")

public class GoodController {
	@Autowired
	GoodService goodService;
	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/{goodId}", produces = "application/json; charset=utf-8", method = {RequestMethod.GET})
	@ResponseBody
	public Object getGood(@PathVariable(value = "goodId") int goodId) throws IOException {
		Object oneGood = goodService.getGood(goodId);
		ObjectMapper mapper = new ObjectMapper();
		String ret = mapper.writeValueAsString(oneGood);
		return ret;
	}

	@RequestMapping(value = "/get_all", produces = "application/json; charset=utf-8", method = {RequestMethod.GET})
	@ResponseBody
	public Object getAll(HttpServletRequest req) throws IOException {
		String openid = req.getParameter("openid");

		List<Good> results = goodService.getAll(openid);
		ObjectMapper mapper = new ObjectMapper();
		String ret = mapper.writeValueAsString(results);
		System.out.println("RETURN" + ret);
		return ret;
	}

	/**
	 * 得到所有id为奇数的纪录
	 *
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/get_all_odd", produces = "application/json; charset=utf-8", method = {
			RequestMethod.GET})
	@ResponseBody
	public Object getAllOdd() throws IOException {
		List<Good> results = goodService.getAllOdd();
		ObjectMapper mapper = new ObjectMapper();
		String ret = mapper.writeValueAsString(results);
		return ret;
	}

	@RequestMapping(value = "/get_all_even", produces = "application/json; charset=utf-8", method = {
			RequestMethod.GET})
	@ResponseBody
	public Object getAllEven() throws IOException {
		List<Good> results = goodService.getAllEven();
		ObjectMapper mapper = new ObjectMapper();
		String ret = mapper.writeValueAsString(results);
		return ret;
	}

	@RequestMapping(value = "/get_title", produces = "application/json; charset=utf-8", method = {RequestMethod.GET})
	@ResponseBody
	public Object getTitle() throws IOException {
		List<Good> results = goodService.getTitle();
		ObjectMapper mapper = new ObjectMapper();
		String ret = mapper.writeValueAsString(results);
		return ret;
	}

	@RequestMapping(value = "/order", produces = "text/html; charset=utf-8", method = {RequestMethod.POST,
			RequestMethod.GET})
	@ResponseBody
	public String saveOrder(HttpServletRequest request, @RequestBody String json) throws IOException {
		// System.out.println("请求的编码方式："+request.getCharacterEncoding());
		// request.setCharacterEncoding("UTF-8");
		// System.out.println("修改后的请求编码方式：" + request.getCharacterEncoding());
		// System.out.println("请求已经送到:" + json);// POST
		// System.out.println("order:"+request.getParameter("order"));//GET
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);// 允许使用未带引号的字段名
		mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true); // 允许使用单引号
		JsonNode node = mapper.readTree(json);
		String exper = node.get("json").toString();
		// 去掉首位的多余双引号和字符串内的\，jackson真的规则多。。。
		String neeee = exper.substring(1, exper.length() - 1);
		neeee = neeee.replace("\\", "");// 不能用replaceAll，注意二者区别,后者参数是正则表达式
		// System.out.println("NEEEE:"+neeee);
		/*
		 * 测试String token=
		 * "[{\"cartId\":8,\"goodId\":2,\"goodName\":\"cz\",\"goodPrice\":134,\"goodMainUrl\":\"http://127.0.0.1:8080/images/2017春装韩范淑女甜美气质ol长袖衬衫女蕾丝花边高领加绒打底衬衣-淘宝网/main.jpg\",\"goodDetailUrls\":\"http://127.0.0.1:8080/images/2017春装韩范淑女甜美气质ol长袖衬衫女蕾丝花边高领加绒打底衬衣-淘宝网/main.jpg\",\"selected\":true,\"num\":1},{\"cartId\":9,\"goodId\":4,\"goodName\":\"gc\",\"goodPrice\":32,\"goodMainUrl\":\"http://127.0.0.1:8080/images/工厂直销防晒衣女中长款雪纺开衫2017夏韩版空调衫短袖大码薄外套-淘宝网/main.jpg\",\"goodDetailUrls\":\"http://127.0.0.1:8080/images/[九平米]藏文藏传佛教t恤观音清心咒六字大明咒密教福德智慧平安-淘宝网/1.jpg,http://127.0.0.1:8080/images/[九平米]藏文藏传佛教t恤观音清心咒六字大明咒密教福德智慧平安-淘宝网/2.jpg,http://127.0.0.1:8080/images/[九平米]藏文藏传佛教t恤观音清心咒六字大明咒密教福德智慧平安-淘宝网/3.jpg,http://127.0.0.1:8080/images/[九平米]藏文藏传佛教t恤观音清心咒六字大明咒密教福德智慧平安-淘宝网/4.jpg,http://127.0.0.1:8080/images/[九平米]藏文藏传佛教t恤观音清心咒六字大明咒密教福德智慧平安-淘宝网/5.jpg,http://127.0.0.1:8080/images/[九平米]藏文藏传佛教t恤观音清心咒六字大明咒密教福德智慧平安-淘宝网/6.jpg,http://127.0.0.1:8080/images/[九平米]藏文藏传佛教t恤观音清心咒六字大明咒密教福德智慧平安-淘宝网/7.jpg,http://127.0.0.1:8080/images/[九平米]藏文藏传佛教t恤观音清心咒六字大明咒密教福德智慧平安-淘宝网/8.jpg,http://127.0.0.1:8080/images/[九平米]藏文藏传佛教t恤观音清心咒六字大明咒密教福德智慧平安-淘宝网/9.jpg,http://127.0.0.1:8080/images/[九平米]藏文藏传佛教t恤观音清心咒六字大明咒密教福德智慧平安-淘宝网/10.jpg,http://127.0.0.1:8080/images/[九平米]藏文藏传佛教t恤观音清心咒六字大明咒密教福德智慧平安-淘宝网/11.jpg,http://127.0.0.1:8080/images/[九平米]藏文藏传佛教t恤观音清心咒六字大明咒密教福德智慧平安-淘宝网/12.jpg,http://127.0.0.1:8080/images/[九平米]藏文藏传佛教t恤观音清心咒六字大明咒密教福德智慧平安-淘宝网/13.jpg\",\"selected\":true,\"num\":1}]";
		 * System.out.println("TOKEN:"+token);
		 */
		// System.out.println("token.equals(token):"+neeee.equals(token));//true
		// System.out.println("token==token:"+(neeee==token));//false
		orderService.deleteAll();
		OrderInfo[] arr = mapper.readValue(neeee, OrderInfo[].class);
		// System.out.println(arr.length);
		for (int i = 0; i < arr.length; i++) {
			/*
			 * System.out.println("NAME:" + arr[i].getGoodName());
			 * System.out.println("MAINURL:" + arr[i].getGoodMainUrl());
			 * System.out.println("NUM:" + arr[i].getNum());
			 */
			BigDecimal goodPrice = new BigDecimal(arr[i].getGoodPrice());
			Order order = new Order(arr[i].getGoodName(), goodPrice, arr[i].getGoodMainUrl(), arr[i].getNum(), arr[i].getOpenid(), "0");
			orderService.insert(order);
		}
		return "I know";
	}
}