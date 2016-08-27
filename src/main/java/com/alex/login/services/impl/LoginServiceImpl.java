package com.alex.login.services.impl;

import com.alex.login.dao.api.UserDao;
import com.alex.login.dao.model.UserEntity;
import com.alex.login.services.api.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alejandro on 8/20/16.
 */

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity authenticate(UserEntity user) {

        return userDao.getUser(user.getUsername(), user.getPassword());

    }

}
