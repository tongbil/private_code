package com.qixin.common;

public class AjaxBeanData {
	private String label;// 模块名称
	private Object data;// 数据对象
	private String result;// 处理结果 成功：sucess 失败：faild
	private String resume;// 错误发生时的提醒信息


	public AjaxBeanData() {
	}


	public String getLabel() {
		return this.label;
	}

	public Object getData() {
		return this.data;
	}

	public String getResult() {
		return this.result;
	}

	public String getResume() {
		return this.resume;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof AjaxBeanData)) return false;
		final AjaxBeanData other = (AjaxBeanData) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$label = this.label;
		final Object other$label = other.label;
		if (this$label == null ? other$label != null : !this$label.equals(other$label)) return false;
		final Object this$data = this.data;
		final Object other$data = other.data;
		if (this$data == null ? other$data != null : !this$data.equals(other$data)) return false;
		final Object this$result = this.result;
		final Object other$result = other.result;
		if (this$result == null ? other$result != null : !this$result.equals(other$result)) return false;
		final Object this$resume = this.resume;
		final Object other$resume = other.resume;
		if (this$resume == null ? other$resume != null : !this$resume.equals(other$resume)) return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof AjaxBeanData;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $label = this.label;
		result = result * PRIME + ($label == null ? 43 : $label.hashCode());
		final Object $data = this.data;
		result = result * PRIME + ($data == null ? 43 : $data.hashCode());
		final Object $result = this.result;
		result = result * PRIME + ($result == null ? 43 : $result.hashCode());
		final Object $resume = this.resume;
		result = result * PRIME + ($resume == null ? 43 : $resume.hashCode());
		return result;
	}

	public String toString() {
		return "AjaxBeanData(label=" + this.label + ", data=" + this.data + ", result=" + this.result + ", resume=" + this.resume + ")";
	}


}
