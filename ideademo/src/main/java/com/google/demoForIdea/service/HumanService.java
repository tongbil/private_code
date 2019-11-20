package com.google.demoForIdea.service;

import com.google.demoForIdea.model.Human;

import java.util.List;

public interface HumanService {
	public Human getHuman(int id);
	List<Human> getAll();
	void  updateHuman(int id);
	void deleteHuman(int id);
	void insertHuman(Human human);
}
