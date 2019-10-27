package com.google.demoForIdea.controller;

import com.google.demoForIdea.model.UserDomain;
import com.google.demoForIdea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


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
		//不用在获取返回的值
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


	@ResponseBody
	@GetMapping("/all")
	public Object findAllUser(
			@RequestParam(name = "pageNum", required = false, defaultValue = "1")
					int pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10")
					int pageSize) {
		return userService.findAllUser(pageNum, pageSize);
	}
}

