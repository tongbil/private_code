package com.qixin.common;

import java.io.File;

public class Ces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String as="E2C45897@EBD77D7D.B16AFF5C";
	 	int lastIndexOf2 = as.lastIndexOf(".");
		String substring = as.substring(lastIndexOf2,lastIndexOf2+2);
		if(as.substring(lastIndexOf2,lastIndexOf2+2).equalsIgnoreCase(".B")){
			String substring2 = as.substring(0, lastIndexOf2);
			String string = substring2+".jpg";
	   	}
	}
	

	public static  boolean deleteDir(File dir) {
	    if (dir.isDirectory()) {
	        String[] children = dir.list();
	   
	        for (int i=0; i<children.length; i++) {
	            boolean success = deleteDir(new File(dir, children[i]));
	            if (!success) {
	                return false;
	            }
	        }
	    }
	    // 目录此时为空，可以删除
	    return dir.delete();
	}
}

