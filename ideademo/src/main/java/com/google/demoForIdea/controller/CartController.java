package com.google.demoForIdea.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.demoForIdea.model.Cart;
import com.google.demoForIdea.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CartService cartService;
	@RequestMapping(value = "/get_all", produces = "application/json; charset=utf-8", method = {RequestMethod.GET})
	@ResponseBody
	public Object getAll(HttpServletRequest req) throws IOException {
		String openid = req.getParameter("openid");
		List<Cart> results = cartService.getAll(openid);
		ObjectMapper mapper = new ObjectMapper();
		String ret = mapper.writeValueAsString(results);


		return ret;
	}

	@RequestMapping(value = "/deleteCar", produces = "application/json; charset=utf-8", method = {RequestMethod.GET})
	@ResponseBody
	public void deleteCar(HttpServletRequest req) {
		Map<String, Object> objectObjectHashMap = new HashMap<>();
		String goodId = req.getParameter("goodId");
		objectObjectHashMap.put("goodId", goodId);
		cartService.deleteCar(objectObjectHashMap);
	}

	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8", method = {RequestMethod.GET})
	@ResponseBody
//警告: No mapping found for HTTP request with URI [/yMybatis/WEB-INF/jsp/cart/add.jsp] in DispatcherServlet with name 'springmvc'
	//这个警告无关紧要: No mapping found for HTTP request with URI [/yMybatis/] in DispatcherServlet with name 'springmvc'
	public void add(HttpServletRequest req) throws IOException {
		Map<String, Object> Map = new HashMap<>();
		Integer goodId = Integer.valueOf(req.getParameter("goodId"));
		Integer num = Integer.valueOf(req.getParameter("num"));
		String openid = req.getParameter("openid");
		Map.put("goodId", goodId);
		Map.put("num", num);
		Map.put("openid", openid);

		Cart one = cartService.oneCar(Map);
		if (one != null) {
			cartService.updateCar(Map);
		} else {
			BigDecimal goodPrice = new BigDecimal(req.getParameter("goodPrice"));

			Cart cart = new Cart(goodId, req.getParameter("goodName"), goodPrice, req.getParameter("goodMainUrl"), req.getParameter("goodDetailUrls"));
			cart.setNum(num);
			cart.setOpenid(openid);
			cartService.insert(cart);
		}

	}

}
