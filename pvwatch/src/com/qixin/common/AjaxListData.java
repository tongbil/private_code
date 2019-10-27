package com.qixin.common;

import java.util.List;

public class AjaxListData {
	private String label;// 模块名称
	private List items;// 数据对象
	private String result;// 处理结果 成功：sucess 失败：faild
	private String resume;// 错误发生时的提醒信息

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

}
