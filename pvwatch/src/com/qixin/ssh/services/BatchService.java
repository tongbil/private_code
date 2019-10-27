package com.qixin.ssh.services;
import com.qixin.ssh.model.Batch;

import java.util.List;




public interface BatchService {
	//获取当前批次号，时间,通用类型的数据
	public List<Batch> getOneBatch(String batchNum,java.util.Date date,java.util.Date dates,String productName);
	//获取详情的数据
	public Batch getDetalsBatch(int batchId);
	//获取所有的企业
	public List<Batch> getList();
	//新增一个企业
	public boolean saveInfo(Batch batch);
	//修改一个企业
	public boolean updateInfo(Batch batch);
	//删除一个企业
	public boolean deleteInfo(int batchId);
	//根据批次号获取对象
	public Batch getPici(int batchNum);

	//根据Mahid获取通用名称
	public List<Object[]> getName(String  mahid);

	//根据通用名称获取批次号
	public List<Object[]> getPici(String  tName);

	//根据通用名称获取批次号
	public List<Object[]> getlikePici(String  tName);

	//根据批次号获取剂型规格
	public List<Object[]> getPiNum(String  PciNum);

	//导入
	public Boolean addAnticipation(List<Batch> Batchs);

	//规整导入手动
	public	Boolean addManualanticipation(List<Batch> Batchs);



}
