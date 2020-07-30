package com.google.demoForIdea.controller;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.demoForIdea.dao.HumanDao;
import com.google.demoForIdea.model.Human;
import com.google.demoForIdea.model.WxAuthPhone;
import com.google.demoForIdea.model.WxPKCS7Encoder;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/human")
public class HumanController {

	@Autowired
	HumanDao humanService;

	@RequestMapping(value = "/addUser", produces = "application/json; charset=utf-8", method = {RequestMethod.GET})
	@ResponseBody
	public Map addUser(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> Map = new HashMap<>();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		String openid = request.getParameter("openid");


		String detail = request.getParameter("detail");
		Human human = new Human();
		human.setOpenid(openid);
		human.setDetail(detail);
		human.setPhone(phone);
		human.setName(name);
		humanService.updateHuman(human);

		Map.put("flag", "true");




		return Map;
	}

	@RequestMapping(value = "/key", produces = "application/json; charset=utf-8", method = {RequestMethod.POST})
	@ResponseBody
	public String key(HttpServletRequest request, HttpServletResponse response, @RequestBody WxAuthPhone wxAuthPhone) throws Exception {

		Human human = new Human();

		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx76844b872561092d&secret=d2424da099ccb55fbf2058a7e14296a7&js_code=" + wxAuthPhone.getCode() + "&grant_type=authorization_code";
		String result = HttpRequest.get(url).body();
		JSONObject resultJson = JSONObject.fromObject(result);
		String openid = String.valueOf(resultJson.get("openid"));
		Human one = humanService.selectOneHuman(openid);
		if (one != null) {
			return one.getOpenid();
		} else {

			human.setOpenid(openid);
			humanService.insertHuman(human);
			//	String session_key = String.valueOf(resultJson.get("session_key"));
			return openid;
		}
	}

	public String decryptPhone(String encryptedData, String sessionKey, String iv, String encodingFormat) throws Exception {


		try {

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

			BASE64Decoder base64Decoder = new BASE64Decoder();

			byte[] _encryptedData = base64Decoder.decodeBuffer(encryptedData);

			byte[] _sessionKey = base64Decoder.decodeBuffer(sessionKey);

			byte[] _iv = base64Decoder.decodeBuffer(iv);

			SecretKeySpec secretKeySpec = new SecretKeySpec(_sessionKey, "AES");

			IvParameterSpec ivParameterSpec = new IvParameterSpec(_iv);

			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

			byte[] original = cipher.doFinal(_encryptedData);

			byte[] bytes = WxPKCS7Encoder.decode(original);

			String originalString = new String(bytes, encodingFormat);
			return originalString;

		} catch (Exception ex) {

			ex.printStackTrace();
			return null;

		}
	}

}
