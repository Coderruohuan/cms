package com.wang.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wang.dao.UserDao;
import com.wang.model.User;
import com.wang.service.TransactionBService;
import com.wang.service.TransactionService;

@Service(value = "transactionService")
public class TransactionServiceImpl implements TransactionService {
	@Resource
	private UserDao userDao;
	@Resource
	private TransactionBService transactionBService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int methodA() throws Exception {
		User user = new User();
		user.setPassword("2018-05-02");
		user.setUsername("测试");
		userDao.insert(user);
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(transactionBService.methodB("1", sf.format(date)));
		if (user.getUsername().equals("测试")) {
			// throw new Exception();
		}
		return 0;
	}

	@Override
	public void print() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sf.format(new Date());
		userDao.updateByName("nww", date);
	}

}
