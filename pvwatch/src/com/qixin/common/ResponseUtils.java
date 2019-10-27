package com.qixin.common;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServletResponse帮助类
 * @author 东子
 * 2017年10月24日14:38:07
 */
public class ResponseUtils {

	public static void renderJson(HttpServletResponse response, String text) {
		render(response, "text/plain;charset=UTF-8", text);
	}

	/**
	 * 发送内容。使用UTF-8编码。
	 * @param response
	 * @param contentType
	 * @param text
	 */
	public static void render(HttpServletResponse response, String contentType, String text) {
		response.setContentType(contentType);
		response.setCharacterEncoding("utf-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		try {
			response.getWriter().write(text);
		} catch (IOException e) {
		}
	}
}
