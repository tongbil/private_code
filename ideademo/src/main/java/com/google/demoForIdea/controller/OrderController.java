package com.google.demoForIdea.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.demoForIdea.model.Order;
import com.google.demoForIdea.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/get_all", produces = "application/json; charset=utf-8", method = {RequestMethod.GET})
	@ResponseBody
	public Object getAll(HttpServletRequest req) throws IOException {
		Map<String, Object> map = new HashMap<>();
		String openid = req.getParameter("openid");
		String status = req.getParameter("status");
		map.put("openid", openid);
		map.put("status", status);
		List<Order> results = orderService.getAll(map);
		ObjectMapper mapper = new ObjectMapper();
		String ret = mapper.writeValueAsString(results);
		System.out.println("/order/get_all:ORDER:" + ret);
		return ret;
	}
	
	/*@RequestMapping(value = "/add", produces = "application/json; charset=utf-8", method = {RequestMethod.GET })
	@ResponseBody//警告: No mapping found for HTTP request with URI [/yMybatis/WEB-INF/jsp/cart/add.jsp] in DispatcherServlet with name 'springmvc'
	//这个警告无关紧要: No mapping found for HTTP request with URI [/yMybatis/] in DispatcherServlet with name 'springmvc'
	public void add(HttpServletRequest req) throws IOException {
		Integer goodId=Integer.valueOf(req.getParameter("goodId"));
		BigDecimal goodPrice=new BigDecimal(req.getParameter("goodPrice"));
		Cart cart=new Cart(goodId,req.getParameter("goodName"),goodPrice, req.getParameter("goodMainUrl"),req.getParameter("goodDetailUrls"));
		orderOperation.insert(cart);
	}*/
}
