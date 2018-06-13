package com.wang.jedis;

import redis.clients.jedis.Jedis;

public class JedisTest {

	public static void main(String[] args) {
		// 可以不指定，默认端口是6379，这是创建和redis的连接
		Jedis jedis = new Jedis("119.29.129.203", 6379);
		jedis.flushAll();
		jedis.flushDB();
		// 选择index=1的数据库，没选择的话默认是对数据库0的操作
		jedis.select(1);
		// 设置值
		jedis.set("wang", "wwn");
		// 清除所有数据库的值
		// 清除当前数据库的值
		// 关闭连接
		jedis.close();
	}

}
