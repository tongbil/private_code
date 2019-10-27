package com.qixin.ssh.services;
import java.util.List;

import com.qixin.ssh.model.Reference;




public interface ReferenceService {

	//通用名称
	public List<Object[]> getName(String  mahid);
	//获取不良反应名称
	public List<Object[]> getblfy(String productId);
	//获取所有的数据
	public List<Object[]> getAllblfy();
	//删除一条数据
	public boolean deleteInfo(int batchId);
	//模糊搜索
	public  List<Object[]> seclittle(String qiyeId,String proName,String zccf,String blName);
	//获取所有组成成分
	public List<Object[]> zccf();
	//新增
	public boolean saveRef(Reference reference);
	//先查询当前修改的对象
	public List<Object[]> selectRefone(int id);
	//修改数据
	public boolean updateRef(Reference reference);
	//查找id最大的
	public  List<Object[]> sid();

}
