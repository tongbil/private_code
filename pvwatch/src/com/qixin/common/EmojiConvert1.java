package com.qixin.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiConvert1 {
    /**
     * @Description 将字符串中的emoji表情转换成可以在utf-8字符集数据库中保存的格式（表情占4个字节，需要utf8mb4字符集） @param str 待转换字符串 @return 转换后字符串 @throws UnsupportedEncodingException exception
     */
    public String emojiConvert1(String str) throws UnsupportedEncodingException {
        String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) try {
            matcher.appendReplacement(sb, "[[" + URLEncoder.encode(matcher.group(1), "UTF-8") + "]]");
        } catch (UnsupportedEncodingException e) {
            throw e;
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
