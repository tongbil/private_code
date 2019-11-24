package com.google.demoForIdea.dao;

import com.google.demoForIdea.model.Human;

public interface HumanDao {

	void insertHuman(Human human);
	void updateHuman(Human human);
	public Human selectOneHuman(String openid);

}
