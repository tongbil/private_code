package com.google.demoForIdea;

import org.junit.jupiter.api.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdeademoApplicationTests {

	@Autowired
	@Qualifier("singleRedisson")
	private RedissonClient redissonClient;

    @Test
    void contextLoads() {
	    RBucket<String> key = redissonClient.getBucket("newday");
	    key.set("新的数据1111111111");
	    System.out.println("获取到新存入的数据："+key.get());
	    // 获取字符串格式的数据
	    RBucket<String> keyObj = redissonClient.getBucket("newday");
	    String s = keyObj.get();
	    System.out.println("获取到昨天存入的数据："+s);
    }



}
