package com.example.S20230403.Dao;

import java.util.List;

import org.apache.catalina.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

	private final SqlSession sqlSession;
	
	@Override
	public List<User> selectUserList() {
		return sqlSession.selectList("selectUserList");
	}

}
