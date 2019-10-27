package com.qixin.ssh.services;

import java.util.List;

import com.qixin.ssh.model.Batch;
import com.qixin.ssh.model.Numpro;




public interface NumproService {
	//根据企业下拉框的value值去搜索所有的产品
	public List<Object[]> getForcomany(String id);
	//根据产品id获取有无数量
	public Numpro getFornumber(int id);
	//新增一个企业
	public boolean saveNum(Numpro numpro);	
	//修改一个企业
	public boolean updateNum(Numpro numpro);
}
