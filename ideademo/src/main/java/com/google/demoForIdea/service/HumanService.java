package com.google.demoForIdea.service;

import com.google.demoForIdea.model.Human;

public interface HumanService {

	void insertHuman(Human human);
	void updateHuman(Human human);
	public Human selectOneHuman(String openid);
}
