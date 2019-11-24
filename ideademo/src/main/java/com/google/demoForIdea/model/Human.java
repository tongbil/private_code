package com.google.demoForIdea.model;

public class Human {
	Integer id;
	String phone;
	String name;
	String detail;
	String openid;

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getId() {
		return id;
	}

	public String getPhone() {
		return phone;
	}

	public String getName() {
		return name;
	}

	public String getDetail() {
		return detail;
	}

	@Override
	public String toString() {
		return "Human{" +
				"id=" + id +
				", phone='" + phone + '\'' +
				", name='" + name + '\'' +
				", detail='" + detail + '\'' +
				", openid='" + openid + '\'' +
				'}';
	}

	public Human() {
		super();
		this.id = id;
		this.detail = detail;
		this.name = name;
		this.phone = phone;
	}


}
