package com.example.S20230403.Dao;

import com.example.S20230403.model.Users;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UsersDaoImpl implements UsersDao{
    private final SqlSessionTemplate sqlSession;

    @Override
    public Users getUserAccount(String userId) {
        return sqlSession.selectOne("Users.getUserAccount", userId);
    }

    @Override
    public void saveUser(Users user) {
        sqlSession.insert("Users.saveUser",user);
    }

    @Override
    public int selectUserCountById(String user_id) {
        return sqlSession.selectOne("Users.selectUserCountById",user_id);
    }

    @Override
    public void saveUser2Api(Users user) {
        sqlSession.insert("Users.saveUser2Api", user);
    }

    @Override
    public int isNewUser(String user_id) {
        return sqlSession.selectOne("Users.isNewUser",user_id);
    }

    @Override
    public void delete(String user_id) {
        sqlSession.delete("Users.delete", user_id);
    }

    @Override
    public void addInfoUser(Users user) {
        sqlSession.update("Users.addInfoUser", user);
    }

    @Override
    public int selectUserCountByNick(String nickname) {
        return sqlSession.selectOne("Users.selectUserCountByNick",nickname);
    }
}
