package com.google.demoForIdea.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.demoForIdea.dao.CategoryDao;
import com.google.demoForIdea.dao.GoodDao;
import com.google.demoForIdea.model.Category;
import com.google.demoForIdea.model.FullCategory;
import com.google.demoForIdea.model.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryDao categoryService;
	@Autowired
	GoodDao goodService;

	@RequestMapping(value = "/get_all", produces = "application/json; charset=utf-8", method = {RequestMethod.GET})
	@ResponseBody
	public Object getAll() throws IOException {
		List<Category> results = categoryService.getAll();
		List<FullCategory> full_results = new ArrayList<FullCategory>();
		for (Category category : results) {
			List<Good> goods = goodService.getByType(category.getCatType());
			FullCategory fullCategory = new FullCategory(category, goods);
			full_results.add(fullCategory);
		}
		ObjectMapper mapper = new ObjectMapper();
		String ret = mapper.writeValueAsString(full_results);
		System.out.println(ret);
		return ret;
	}
}
