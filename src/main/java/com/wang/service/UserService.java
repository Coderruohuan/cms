package com.wang.service;

import com.wang.model.User;

public interface UserService {

	void insert(User user);

	int update(User user);

	User findByName(String username);

	void updateByName();
}
