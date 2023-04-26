package com.example.S20230403.service.yheService;

import com.example.S20230403.auth.PrincipalDetail;
import com.example.S20230403.model.Users;

import java.util.Map;

public interface UsersService {

    Users getUserAccount(String userId);
    void saveUser(Users user);

    int exists(String userId);

    void saveUser2Api(Users user);

    int isNewUser(String userId);

    void delete(String userId);

    void addInfoUser(Users users);

    int existsNick(String nickname);
}
