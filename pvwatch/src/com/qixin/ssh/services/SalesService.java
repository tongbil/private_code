package com.qixin.ssh.services;
import java.util.List;

import com.qixin.ssh.model.Batch;
import com.qixin.ssh.model.Numpro;
import com.qixin.ssh.model.Sales;




public interface SalesService {
	//获取所有销量维护
	public List<Sales> getList();
	//获取搜索后的数据
	public List<Object[]> getOneSales(String qiyeId,String genericFunction,String strength,java.util.Date date,java.util.Date datese);

	//根据通用名称获取批次号
	public List<Object[]> getSalesName(String  tName);
	
	//selProduct获取通用名称规格和批准文号
	public List<Object[]> getProduct();
	
	//获取省,
	public List<Object[]> getSheng();
	//获取市
	public List<Object[]> getShi(String shi);
	//新增
	public boolean saveSales(Sales sales);	
	
}
