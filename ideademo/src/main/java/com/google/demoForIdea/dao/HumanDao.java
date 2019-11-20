package com.google.demoForIdea.dao;

import com.google.demoForIdea.model.Human;

import java.util.List;

public interface HumanDao {
	public Human getHuman(int id);
	List<Human> getAll();
	void  updateHuman(int id);
	void deleteHuman(int id);
	void insertHuman(Human human);
}
