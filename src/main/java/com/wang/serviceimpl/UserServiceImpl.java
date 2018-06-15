package com.wang.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wang.dao.UserDao;
import com.wang.model.User;
import com.wang.service.TransactionService;
import com.wang.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Autowired
	private TransactionService transactionService;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
	public void insert(User user) {
		userDao.insert(user);
		transactionService.print();
		this.updateByName();
		// throw new RuntimeException();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void updateByName() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sf.format(new Date());
		userDao.updateByName("wwn", date);
		throw new RuntimeException();
	}

	@Override
	@Transactional
	public int update(User user) {
		return userDao.update(user);
	}

	@Override
	@Cacheable(value = "user", key = "username")
	public User findByName(String username) {
		System.out.println("查询数据库了.......");
		return userDao.findByName(username);
	}

}
