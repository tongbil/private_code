package com.google.demoForIdea.service.impl;

import com.google.demoForIdea.dao.CartDao;
import com.google.demoForIdea.model.Cart;
import com.google.demoForIdea.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "cartService")
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public List<Cart> getAll(String openid) {
        return cartDao.getAll(openid);
    }

    @Override
    public int insert(Cart cart) {
        return cartDao.insert(cart);
    }

    @Override
    public Cart oneCar(Map<String, Object> Map) {
        return cartDao.oneCar(Map);
    }

    @Override
    public void updateCar(Map<String, Object> Map) { cartDao.updateCar(Map);
    }

    @Override
    public void deleteCar(Map<String, Object> Map) {
        cartDao.deleteCar(Map);
    }
}
