package com.alex.login.services.impl;

import com.alex.login.dao.api.UserDao;
import com.alex.login.dao.impl.UserDaoImpl;
import com.alex.login.dao.model.UserEntity;
import com.alex.login.services.api.LoginService;
import org.springframework.stereotype.Service;

/**
 * Created by alejandro on 8/20/16.
 */

@Service
public class LoginServiceImpl implements LoginService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public UserEntity authenticate(UserEntity user) {

        //return userDao.getUser(user.getUserName(), user.getPassword());

        user.setFirstName("Alejandro");
        user.setLastName("Bautista");
        user.setRole("Aministrador");

        return user;

    }

}
