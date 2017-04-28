package com.lyg.cloud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.cloud.model.User;

@Repository
public interface UserDao {

	List<User> findAll();
	
	User findUserById(String id);
}
