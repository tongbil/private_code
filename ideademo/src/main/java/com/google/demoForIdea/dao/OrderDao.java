package com.google.demoForIdea.dao;

import com.google.demoForIdea.model.Order;

import java.util.List;

public interface OrderDao {
	int insert(Order order);

	List<Order> getAll();

	void deleteAll();
}
