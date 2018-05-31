package com.wang.dao;

import org.apache.ibatis.annotations.Param;

import com.wang.model.User;

public interface UserDao {

	int insert(@Param("user") User user);

	int updateByName(@Param("username") String username, @Param("password") String password);

	int update(@Param("user") User user);

	User findByName(@Param("username") String username);

}
