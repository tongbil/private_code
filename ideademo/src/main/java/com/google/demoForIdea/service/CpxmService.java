package com.google.demoForIdea.service;

import java.util.List;
import java.util.Map;

public interface CpxmService {
	//新增模板表  NJWEB_CPXM_TEMPLATE
	int insert_Template(Map<String,Object> map);
	//新增模板打分项表 NJWEB_CPXM_TEMPLATE_ITEM
	int insert_Template_item(Map<String,Object> map);
	//新增模板打分项详细配置表 NJWEB_CPXM_TEMPLATE_ITEM_CONFIG
	int insert_Template_item_config(Map<String,Object> map);
	//新增模板总分项配置表 NJWEB_CPXM_TEMPLATE_ZF_CONFIG
	int person(Map<String,Object> map);
	//查询模板
	List<Map>select_template();
}
