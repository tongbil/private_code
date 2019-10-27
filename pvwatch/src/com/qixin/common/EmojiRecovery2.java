package com.qixin.common;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiRecovery2 {
    /**
    * @Description 还原utf8数据库中保存的含转换后emoji表情的字符串
    * @param str
    * 转换后的字符串
    * @return 转换前的字符串
    * @throws UnsupportedEncodingException
    * exception
    */
	  public  String emojiRecovery2(String str)
			    throws UnsupportedEncodingException {
			    String patternString = "\\[\\[(.*?)\\]\\]";

			    Pattern pattern = Pattern.compile(patternString);
			    Matcher matcher = pattern.matcher(str);

			    StringBuffer sb = new StringBuffer();
			    while(matcher.find()) {
			    try {
			    matcher.appendReplacement(sb,
			    URLDecoder.decode(matcher.group(1), "UTF-8"));
			    } catch(UnsupportedEncodingException e) {
			 
			    throw e;
			    }
			    }
			    matcher.appendTail(sb);
			   
			    return sb.toString();
			    }
}
