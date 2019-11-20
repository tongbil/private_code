package com.google.demoForIdea.service;

import com.google.demoForIdea.model.Cart;

import java.util.List;

public interface CartService {
	List<Cart> getAll();
	int insert (Cart cart);
}
