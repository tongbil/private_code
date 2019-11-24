package com.google.demoForIdea.dao;

import com.google.demoForIdea.model.Good;

import java.util.List;

public interface GoodDao {
	public Good getGood(int good_id);
	List<Good> getAll(String openid);
	List<Good> getAllOdd();
	List<Good> getAllEven();
	public Good getCartInfo(int good_id);
	List<Good> getByType(String goodType);
	List<Good> getTitle();




}
