package com.google.demoForIdea.service.impl;

import com.google.demoForIdea.dao.CartDao;
import com.google.demoForIdea.model.Cart;
import com.google.demoForIdea.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "cartService")
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public List<Cart> getAll() {
        return cartDao.getAll();
    }

    @Override
    public int insert(Cart cart) {
        return cartDao.insert(cart);
    }
}
