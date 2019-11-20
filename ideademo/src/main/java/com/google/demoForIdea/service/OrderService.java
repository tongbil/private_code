package com.google.demoForIdea.service;

import com.google.demoForIdea.model.Order;

import java.util.List;

public interface OrderService {
	List<Order> getAll();
	int insert(Order order);
	void deleteAll();
}
