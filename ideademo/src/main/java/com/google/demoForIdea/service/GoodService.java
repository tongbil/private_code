package com.google.demoForIdea.service;

import com.google.demoForIdea.model.Good;

import java.util.List;

public interface GoodService {
	public Good getGood(int good_id);
	List<Good> getAll();
	List<Good> getAllOdd();
	List<Good> getAllEven();
	public Good getCartInfo(int good_id);
	List<Good> getByType(String goodType);
	List<Good> getTitle();
}
