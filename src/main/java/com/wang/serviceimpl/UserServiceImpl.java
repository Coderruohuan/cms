package com.wang.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
	public void insert(User user) {
		userDao.insert(user);
		this.updateByName();
		transactionService.print();
		// throw new RuntimeException();
	}

	@Override
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
	public User findByName(String username) {
		return userDao.findByName(username);
	}

}
