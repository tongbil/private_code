package com.google.demoForIdea;

import com.google.demoForIdea.model.User;
import com.google.demoForIdea.model.UserDomain;
import com.google.demoForIdea.redis.RedissonService;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class IdeademoApplicationTests {

	@Autowired
	@Qualifier("singleRedisson")
	private RedissonClient redissonClient;
	@Autowired
	@Qualifier("redissonService")
	private RedissonService redissonService;

    @Test
    void contextLoads() {

	    List<String> user1 = new ArrayList<>();

	    List<UserDomain> userDoman20 = new ArrayList<>();
	    //test方法参数是T 是泛型，不管user1是String还是对象都能进去，返回值和当时传参一样
	    List<String> test = test(user1);
	  /* List<?> user = new ArrayList<>();
	    List<T> user2 = new ArrayList<>();

	    List<String> test= test(user);
	    List<User> test2= test(user2);
	    System.out.println(test);
	    System.out.println(test2);*/

	    UserDomain userDomain = new UserDomain();
	    userDomain.setUsername("ss");
	    redissonService.setRBucket("name",userDomain);

	    RBucket <UserDomain> keyObj = redissonService.getRBucket("name");
	    UserDomain userDomain2 = keyObj.get();
	    System.out.println("获取到昨天存入的数据："+userDomain2.toString());
    }

   public static <T> List<T> test(List<T> value){
    	return  value;
    }
	public static void user (List<User> user){
		for (User user10:  user){

		}
	}
	public static void user2 (List<UserDomain> user){
		for (UserDomain user10:  user){

		}
	}
}
