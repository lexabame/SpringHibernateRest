package com.alex.login.service.impl;

import com.alex.login.dao.api.UserDao;
import com.alex.login.dao.entities.UserEntity;
import com.alex.login.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by alejandro on 3/19/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public UserEntity getUser(final Long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public List<UserEntity> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public UserEntity addUser(final UserEntity userEntity){

        userEntity.setActive(1);
        userEntity.setCreationDate(new Date());

        userDao.addUser(userEntity);

        UserEntity user = userDao.getUserByEmail(userEntity.getAccount().getEmail());

        if(user == null){
            //throw new Exception("An erro occurred");
        }

        return user;
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public UserEntity updateUser(final UserEntity userEntity) {

        UserEntity user = userDao.getUserById(userEntity.getId());

        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setAccount(userEntity.getAccount());
        user.setActive(userEntity.getActive());
        user.setModificationDate(new Date());

        userDao.updateUser(user);

        return user;

    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public void deleteUser(final Long id) {

        UserEntity user = userDao.getUserById(id);

        user.setActive(0);
        user.setModificationDate(new Date());

        userDao.deleteUser(user);

    }

}
