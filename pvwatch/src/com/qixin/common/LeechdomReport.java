package com.qixin.common;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.ClientProtocolException;

public class LeechdomReport {
	
public static void main(String[] args) throws KeyManagementException, ClientProtocolException, NoSuchAlgorithmException, IOException {
	File tempFile = new File("c:\\mailtemp\\批次.xls");
	
	System.out.println(PropertiesUtil.readProperty("fileServer"));
	System.out.println(System.getProperty("user.dir"));
}
}
