package com.wang.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wang.model.User;
import com.wang.service.TransactionBService;
import com.wang.service.TransactionService;
import com.wang.service.UserService;

@Controller
@RequestMapping("/v1/api/user")
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private TransactionService transactionService;
	@Resource
	private TransactionBService transactionBService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(User user) {
		userService.insert(user);
		return "test.html";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test() {
		try {
			transactionService.methodA();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public void test2() {
		transactionBService.test();
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public void find(String username) {
		User user = userService.findByName(username);
		System.out.println(user.getUsername());
	}
}
