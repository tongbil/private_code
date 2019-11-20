package com.google.demoForIdea.service.impl;

import com.google.demoForIdea.dao.CategoryDao;
import com.google.demoForIdea.model.Category;
import com.google.demoForIdea.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }


}
