package com.wang.dao;

import org.apache.ibatis.annotations.Param;

import com.wang.model.User;

public interface UserDao {

	int insert(@Param("user") User user);

	int update(@Param("password") String password, @Param("id") Long id);

	int updateByName(@Param("username") String username, @Param("password") String password);

}
