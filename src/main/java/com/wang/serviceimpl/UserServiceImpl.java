package com.wang.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wang.dao.UserDao;
import com.wang.model.User;
import com.wang.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

}
