package com.alex.login.service.api;

import com.alex.login.dao.entities.UserEntity;

/**
 * Created by alejandro on 3/19/17.
 */
public interface UserService {

    public UserEntity addUser(final UserEntity userEntity);

}
