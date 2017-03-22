package com.alex.login.service.api;

import com.alex.login.dao.entities.UserEntity;

import java.util.List;

/**
 * Created by alejandro on 3/19/17.
 */
public interface UserService {

    public UserEntity getUser(final Long id);

    public List<UserEntity> getUsers();

    public UserEntity addUser(final UserEntity userEntity);

    public UserEntity updateUser(final UserEntity userEntity);

    public void deleteUser(final Long id);

}
