package com.google.demoForIdea.model;

import java.math.BigDecimal;

public class Cart {
	Integer cartId;
	Integer goodId;
	String goodName;
	BigDecimal goodPrice;
	String goodMainUrl;
	String goodDetailUrls;
	Integer selected;
	Integer num;
	String openid;

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getOpenid() {
		return openid;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getGoodId() {
		return goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
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

	public Integer getSelected() {
		return selected;
	}

	public void setSelected(Integer selected) {
		this.selected = selected;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getGoodDetailUrls() {
		return goodDetailUrls;
	}

	public void setGoodDetailUrls(String goodDetailUrls) {
		this.goodDetailUrls = goodDetailUrls;
	}


	public Cart(Integer cartId, Integer goodId, String goodName, BigDecimal goodPrice, String goodMainUrl,String goodDetailUrls,
			Integer selected, Integer num,String openid) {
		super();
		this.cartId = cartId;
		this.goodId = goodId;
		this.goodName = goodName;
		this.goodPrice = goodPrice;
		this.goodMainUrl = goodMainUrl;
		this.goodDetailUrls=goodDetailUrls;
		this.selected = selected;
		this.num = num;
		this.openid = openid;
	}

	public Cart(Integer goodId, String goodName, BigDecimal goodPrice, String goodMainUrl,String goodDetailUrls) {
		super();
		this.goodId = goodId;
		this.goodName = goodName;
		this.goodPrice = goodPrice;
		this.goodMainUrl = goodMainUrl;
		this.goodDetailUrls=goodDetailUrls;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", goodId=" + goodId + ", goodName=" + goodName + ", goodPrice=" + goodPrice
				+ ", goodMainUrl=" + goodMainUrl + ", goodDetailUrls=" + goodDetailUrls + ", selected=" + selected
				+ ", num=" + num + "]";
	}
	
}
