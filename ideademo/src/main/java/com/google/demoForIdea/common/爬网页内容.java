package com.google.demoForIdea.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 爬网页内容 {
	public static void main(String[] args) {
		String query = "美元(USD)";
		String html = getHtml();

		String pattern = "<tr([\\s\\S]*?)</tr>";
		Pattern p = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(html);
		String result = "";
		while (m.find()) {
			String s = m.group();
			if(s.contains(query)){
				result = m.group();
			}
		}

		String pattern1 = "<td([\\s\\S]*?)</td>";
		Pattern p2 = Pattern.compile(pattern1,Pattern.CASE_INSENSITIVE);
		Matcher m2 = p2.matcher(result);

		List<String> list = new ArrayList<>();
		while (m2.find()) {
			String s = m2.group();
			if(!s.contains("</ a>")){
				s = s.replace("<td align=\"center\">","");
				s = s.replace("</td>","");
				//s = s.replaceAll("<a([\\s\\S]*?)</ a>","");
				list.add(s.trim());
			}

		}
		System.out.println(list.size());
		System.out.println(list.toString());
	}
	public  static String getHtml(){
		StringBuffer sb = new StringBuffer();
		try {
			String u = "https://htmoon.finance";
			URL url = new URL(u);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36)");

			InputStream in = urlConnection.getInputStream();
			InputStreamReader sr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(sr);
			String data = br.readLine();

					sb.append(data);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
