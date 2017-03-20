package com.alex.login.service.impl;

import com.alex.login.dao.api.UserDao;
import com.alex.login.dao.entities.UserEntity;
import com.alex.login.service.api.LoginService;
import com.alex.login.service.exceptions.UserAuthenticationExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alejandro on 8/20/16.
 */

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public UserEntity authenticate(final UserEntity userEntity) throws UserAuthenticationExeption {

        UserEntity user = userDao.getUserByEmail(userEntity.getAccount().getEmail());

        if(user == null || !(user.getAccount().getSecret().equals(userEntity.getAccount().getSecret()))){
            throw new UserAuthenticationExeption("Authentication error!");
        }

        return user;
    }
}
