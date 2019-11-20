package com.google.demoForIdea.dao;

import com.google.demoForIdea.model.Cart;

import java.util.List;

public interface CartDao {
	int insert(Cart cart);

	List<Cart> getAll();
}
