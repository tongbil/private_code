package com.google.demoForIdea;

import com.google.demoForIdea.dao.Duoshujuyuan2Dao;
import com.google.demoForIdea.dao.DuoshujuyuanDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = IdeademoApplication.class)
@Slf4j
public class AppTest {
	@Autowired
	private DuoshujuyuanDao duoshujuyuanService;
	@Autowired
	private Duoshujuyuan2Dao duoshujuyuan2Service;

	boolean flag =false;

	@org.junit.Test
	public void testDynamicDatasource() {

		System.out.println(!flag);
		/*HashMap<String, Object> map = new HashMap<>();
		List<Map> maps1 = duoshujuyuanService.selectByOddUserId(map);
		List<Map> maps2 = duoshujuyuan2Service.selectByEvenUserId(map);
		System.out.println("mysql"+maps1);
		System.out.println("本地"+maps2);*/
	}
	//查看springboot版本
	@Test
	public void Test1(){
		//spring
		String version = SpringVersion.getVersion();
		//springboot
		String version1 = SpringBootVersion.getVersion();
		System.out.println(version);
		System.out.println(version1);
	}
}
