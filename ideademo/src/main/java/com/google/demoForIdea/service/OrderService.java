package com.google.demoForIdea.service;

import com.google.demoForIdea.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
	List<Order> getAll(Map<String,Object> map);
	int insert(Order order);
	void deleteAll();
}
