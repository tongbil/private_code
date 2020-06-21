package com.google.demoForIdea.common;

import com.google.gson.Gson;

import java.util.List;

public class GSON_RESULT {
	//直接alt+s
	/**
	 * type : forecast1d
	 * weatherinfo : [{"city":"北京","cityid":"1","temp1":"22℃","temp2":"10℃","weather":"晴","ptime":"11:00"},{"city":"上海","cityid":"2","temp1":"24℃","temp2":"12℃","weather":"晴","ptime":"11:00"}]
	 */

	private String type;
	private List<WeatherinfoBean> weatherinfo;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<WeatherinfoBean> getWeatherinfo() {
		return weatherinfo;
	}

	public void setWeatherinfo(List<WeatherinfoBean> weatherinfo) {
		this.weatherinfo = weatherinfo;
	}

	public static class WeatherinfoBean {
		/**
		 * city : 北京
		 * cityid : 1
		 * temp1 : 22℃
		 * temp2 : 10℃
		 * weather : 晴
		 * ptime : 11:00
		 */

		private String city;
		private String cityid;
		private String temp1;
		private String temp2;
		private String weather;
		private String ptime;

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCityid() {
			return cityid;
		}

		public void setCityid(String cityid) {
			this.cityid = cityid;
		}

		public String getTemp1() {
			return temp1;
		}

		public void setTemp1(String temp1) {
			this.temp1 = temp1;
		}

		public String getTemp2() {
			return temp2;
		}

		public void setTemp2(String temp2) {
			this.temp2 = temp2;
		}

		public String getWeather() {
			return weather;
		}

		public void setWeather(String weather) {
			this.weather = weather;
		}

		public String getPtime() {
			return ptime;
		}

		public void setPtime(String ptime) {
			this.ptime = ptime;
		}
	}

	public static void main(String[] args) {
		Gson gson = new Gson();
		String jsonData="{\n" +
				"    \"type\": \"forecast1d\",\n" +
				"    \"weatherinfo\": [\n" +
				"        {\n" +
				"            \"city\": \"北京\",\n" +
				"            \"cityid\": \"1\",\n" +
				"            \"temp1\": \"22℃\",\n" +
				"            \"temp2\": \"10℃\",\n" +
				"            \"weather\": \"晴\",\n" +
				"            \"ptime\": \"11:00\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"city\": \"上海\",\n" +
				"            \"cityid\": \"2\",\n" +
				"            \"temp1\": \"24℃\",\n" +
				"            \"temp2\": \"12℃\",\n" +
				"            \"weather\": \"晴\",\n" +
				"            \"ptime\": \"11:00\"\n" +
				"        }\n" +
				"    ]\n" +
				"}";
		GSON_RESULT result = gson.fromJson(jsonData, GSON_RESULT.class);
		System.out.println(result.getType());
	}

}

