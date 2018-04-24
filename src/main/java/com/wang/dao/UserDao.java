package com.wang.dao;

import org.apache.ibatis.annotations.Param;

import com.wang.model.User;

public interface UserDao {

	int insert(@Param("user") User user);

}
