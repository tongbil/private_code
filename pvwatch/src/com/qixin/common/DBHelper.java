package com.qixin.common;



import com.google.gson.JsonObject;

public class DBHelper {  
		public static void main(String[] args) throws Exception {
			SdProposeOrder sdProposeOrder = new SdProposeOrder();
	
			sdProposeOrder.setObject("重复项设置");
			sdProposeOrder.setOptionType("修改");
			sdProposeOrder.setMahId(null);
				String json = JSONObjectTool.getJson(sdProposeOrder);
				System.out.println(json);
		}
}  