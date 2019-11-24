package com.google.demoForIdea.dao;

import com.google.demoForIdea.model.Cart;

import java.util.List;
import java.util.Map;

public interface CartDao {
	int insert(Cart cart);
	public Cart oneCar(Map<String, Object> Map);
	List<Cart> getAll(String openid);
	void updateCar(Map<String, Object> Map);
	void deleteCar(Map<String, Object> Map);
}
