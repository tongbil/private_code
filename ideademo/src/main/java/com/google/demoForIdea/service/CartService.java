package com.google.demoForIdea.service;

import com.google.demoForIdea.model.Cart;

import java.util.List;
import java.util.Map;

public interface CartService {
	List<Cart> getAll(String openid);
	int insert (Cart cart);
	public Cart oneCar(Map<String, Object> Map);
	void updateCar(Map<String, Object> Map);
	void deleteCar(Map<String, Object> Map);
}
