package com.alex.login.service.impl;

import com.alex.login.dao.api.UserDao;
import com.alex.login.dao.entities.UserEntity;
import com.alex.login.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alejandro on 3/19/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public UserEntity addUser(final UserEntity userEntity){

        userDao.addUser(userEntity);

        UserEntity user = userDao.getUserByEmail(userEntity.getAccount().getEmail());

        if(user == null){
            //throw new Exception("An erro occurred");
        }

        return user;
    }

}
