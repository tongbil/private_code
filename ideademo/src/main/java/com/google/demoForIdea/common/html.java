package com.google.demoForIdea.common;

import org.apache.commons.lang3.StringUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class html {
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
				s = s.replaceAll("<a([\\s\\S]*?)</a>","");
				 list.add(s.trim());
			}
		}
		System.out.println(list.toString());
	}
       public  static String getHtml(){
		StringBuffer sb = new StringBuffer();
		try {
			String u = "http://www.cebbank.com/eportal/ui?pageId=477257";
			URL url = new URL(u);
			InputStream in = url.openStream();
			InputStreamReader sr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(sr);
			String data = br.readLine();
			while (data!=null){
				data = br.readLine();
				if(!StringUtils.isEmpty(data)){
					sb.append(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}