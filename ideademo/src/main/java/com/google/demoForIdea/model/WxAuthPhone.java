package com.google.demoForIdea.model;

public class WxAuthPhone {
	String encryptedData;
	String sessionKey;
	String iv;
String code;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}


	public String getSessionKey() {
		return sessionKey;
	}

	public String getIv() {
		return iv;
	}

	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}

	public String getEncryptedData() {
		return encryptedData;
	}
}
