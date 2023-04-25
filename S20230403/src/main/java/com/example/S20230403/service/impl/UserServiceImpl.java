package com.example.S20230403.service.impl;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.S20230403.Dao.UserDao;
import com.example.S20230403.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private final UserDao userDao;
	
	@Override
	public List<User> findUsers() {
		List<User> userList = userDao.selectUserList();
		return userList;
	}

}
