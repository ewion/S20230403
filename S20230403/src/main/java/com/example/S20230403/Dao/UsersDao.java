package com.example.S20230403.Dao;

import com.example.S20230403.model.Users;

import java.util.Map;

public interface UsersDao {
    Users getUserAccount(String userId);

    void saveUser(Users user);

    int selectUserCountById(String user_id);

    void saveUser2Api(Users user);

    int isNewUser(String userId);

    void delete(String userId);

    void addInfoUser(Users users);

    int selectUserCountByNick(String nickname);
}
