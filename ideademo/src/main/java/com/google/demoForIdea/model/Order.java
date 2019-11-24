package com.google.demoForIdea.model;

import java.math.BigDecimal;

public class Order {
	Integer orderId;
	String goodName;
	BigDecimal goodPrice;
	String goodMainUrl;
	Integer goodNum;
	String openid;
	String status;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public BigDecimal getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getGoodMainUrl() {
		return goodMainUrl;
	}
	public void setGoodMainUrl(String goodMainUrl) {
		this.goodMainUrl = goodMainUrl;
	}
	public Integer getGoodNum() {
		return goodNum;
	}
	public void setGoodNum(Integer goodNum) {
		this.goodNum = goodNum;
	}
	public Order(Integer orderId, String goodName, BigDecimal goodPrice, String goodMainUrl, Integer goodNum,String openid,String status) {
		super();
		this.orderId = orderId;
		this.goodName = goodName;
		this.goodPrice = goodPrice;
		this.goodMainUrl = goodMainUrl;
		this.goodNum = goodNum;
		this.openid = openid;
		this.status = status;
	}
	public Order(String goodName, BigDecimal goodPrice, String goodMainUrl, Integer goodNum,String openid,String status) {
		super();
		this.goodName = goodName;
		this.goodPrice = goodPrice;
		this.goodMainUrl = goodMainUrl;
		this.goodNum = goodNum;
		this.openid = openid;
		this.status = status;
	}
}
