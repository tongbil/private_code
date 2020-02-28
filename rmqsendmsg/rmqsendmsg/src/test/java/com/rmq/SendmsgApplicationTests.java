package com.rmq;

import com.rmq.service.SendMsgService;
import com.sunny.bo.Userinfos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendmsgApplicationTests {
 @Autowired
 private SendMsgService sendMsgService;
	@Test
	public void contextLoads() {
		for (int i=0;i<100;i++){
			Userinfos us=new Userinfos(i+1,"zhangsan","123",new Date(),1);
			sendMsgService.sendUserMsg(us);
			sendMsgService.sendShopMsg(us);
		}

	}

}
