package com.google.demoForIdea.dao;

import com.google.demoForIdea.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderDao {
	int insert(Order order);

	List<Order> getAll(Map<String,Object> map);

	void deleteAll();
}
