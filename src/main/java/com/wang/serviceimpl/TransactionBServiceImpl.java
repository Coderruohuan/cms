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
		return userDao.updateByName(username, password);
	}

}
