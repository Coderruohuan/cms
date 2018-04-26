package com.wang.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wang.model.User;
import com.wang.service.UserService;

@Controller
@RequestMapping("/v1/api/user")
public class UserController {
	@Resource
	private UserService userService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(User user) {
		userService.insert(user);
	}

}
