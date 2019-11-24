package com.google.demoForIdea.service.impl;

import com.google.demoForIdea.dao.OrderDao;
import com.google.demoForIdea.model.Order;
import com.google.demoForIdea.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getAll(Map<String,Object> map) {
        return orderDao.getAll(map);
    }

    @Override
    public int insert(Order order) {
        return orderDao.insert(order);
    }

    @Override
    public void deleteAll() {
        orderDao.deleteAll();
    }
}
