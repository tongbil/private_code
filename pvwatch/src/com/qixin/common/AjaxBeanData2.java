package com.qixin.common;

public class AjaxBeanData2 {
	private String label;// 模块名称
	private Object data;// 数据对象
	private String result;// 处理结果 成功：sucess 失败：faild
	private String resume;// 错误发生时的提醒信息

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

 

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
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
		public static void main(String[] args) {
			String xlString="xls";
			String xxxString="XLS";
			System.out.println(xlString.equalsIgnoreCase(xxxString)+"?");
			System.out.println(xlString.equals(xxxString)+"?");
		}
}
