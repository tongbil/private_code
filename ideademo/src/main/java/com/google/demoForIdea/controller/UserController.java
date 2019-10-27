package com.google.demoForIdea.controller;
import com.google.demoForIdea.common.ZxingUtils;
import com.google.demoForIdea.model.UserDomain;
import com.google.demoForIdea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.ByteArrayOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@PostMapping("/add")
	public int addUser(UserDomain user) {
		return userService.addUser(user);
	}

	@ResponseBody
	@PostMapping("/sel")
	public Map sel() {
		//调单个值
               /* create or replace procedure p_querynameandsalxxx(in_cityid in T_SYS_CITY.CITYID%type,
                        on_cityno out T_SYS_CITY.CITYNO%type) as
                v_cityid T_SYS_CITY.CITYID%type;
                v_name   T_SYS_CITY.CNAME%type;
                --游标
                cursor c_city is
                select cname, cityid from T_SYS_CITY;
                begin
                select cityno into on_cityno from T_SYS_CITY where cityid = in_cityid;
                end;
*/
		//   Map<String, Object> map = new HashMap<String, Object>();
		//  map.put("in_cityid",2);
		//不用获取返回值
		// userService.selUser(map);
		// System.out.println(map);
		//调游标
               /* create or replace procedure p_querynameandsalxxx(in_cityid in T_SYS_CITY.CITYID%type,
                        on_cityno out T_SYS_CITY.CITYNO%type) as
                v_cityid T_SYS_CITY.CITYID%type;
                v_name   T_SYS_CITY.CNAME%type;
                --游标
                cursor c_city is
                select cname, cityid from T_SYS_CITY;
                begin
                select cityno into on_cityno from T_SYS_CITY where cityid = in_cityid;
                end;
*/
		//获取游标
		Map<String, Object> map1 = new HashMap<String, Object>();
		//不需要获取返回的值
		userService.getAllTeacherInfo(map1);
		ArrayList<Map<String, Object>> cursorList = (ArrayList<Map<String, Object>>) map1.get("result");
		if (cursorList != null && cursorList.size() != 0) {
			for (Map<String, Object> cursor : cursorList)
				System.out.println(cursor);
		}
		//继续返回map
		System.out.println(map1);

		return null;
	}

/*二维码验证登陆*/
	@ResponseBody
	@RequestMapping("/qrcode")
	public void findAllUser(HttpServletRequest request, HttpServletResponse response) {
		//自定义内容 如果想要扫一扫获取图片就把网络图片地址放下面2
		String contents = "https://avatars1.githubusercontent.com/u/54196360?s=460&v=4";
		int width = 300; int height = 300; int margin = 2;

		try {
			BufferedImage QRcode = ZxingUtils.createQRImage(contents, width, height, margin);

			//获取域名
			//StringBuffer url = request.getRequestURL();
			//String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();

			String logoPath = "C:\\Users\\tangcomes\\Desktop\\liufang\\java\\ideademo\\src\\main\\resources\\static\\images\\logo.png";
			int logoSize = 4;
			BufferedImage qRImageWithLogo = ZxingUtils.addQRImagelogo(QRcode, width, height, logoPath, logoSize);

			// 写入返回
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(qRImageWithLogo, "png", baos);

			byte[] QRJPG = baos.toByteArray();
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/jpeg");

			ServletOutputStream os = response.getOutputStream();
			os.write(QRJPG); // 自此完成一套，图片读入，写入流，转为字节数组，写入输出流
			os.flush();
			os.close();
			baos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

