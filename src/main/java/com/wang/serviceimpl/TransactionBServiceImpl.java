package com.wang.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wang.dao.UserDao;
import com.wang.service.TransactionBService;

@Service
public class TransactionBServiceImpl implements TransactionBService {
	@Resource
	private UserDao userDao;

	@Override
	public int methodB(String username, String password) {
		System.out.println("目标对象执行");
		// return userDao.updateByName(username, password);
		return 1;
	}

}
