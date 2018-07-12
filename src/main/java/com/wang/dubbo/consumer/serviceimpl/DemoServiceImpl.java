package com.wang.dubbo.consumer.serviceimpl;

import com.wang.dubbo.consumer.service.DemoService;

public class DemoServiceImpl implements DemoService {

	@Override
	public String sayHello(String name) {
		return "hello," + name;
	}

}
