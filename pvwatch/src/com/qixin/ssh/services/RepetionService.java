package com.qixin.ssh.services;


import com.qixin.ssh.model.Repetion;

import java.util.List;
import java.util.Map;

public interface RepetionService {
	public List<Repetion> getAllRepetion();
	public Repetion  updateRepetion(String id);
	public List<Repetion> getStatus();
	public List<Object[]>  upAreaCode();
	public List<Object[]>  putReportAll();
	public Object getContent(int obj);
	public boolean upOneReport(String obj,String sex,String age,String dw);
	
	public List<Object[]> getUser();
}
