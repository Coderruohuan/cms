package com.wang.jedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wang.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/applicationContext.xml" })
public class RedisTemplateTest {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Autowired
	private UserService userService;

	public void test() {
		redisTemplate.opsForValue().set("wang1", "2018-6-13 17:14");
		// System.out.println(redisTemplate.opsForValue().get("测试"));
	}

	@Test
	public void userTest() {
		userService.findByName("wwn");
	}

}
