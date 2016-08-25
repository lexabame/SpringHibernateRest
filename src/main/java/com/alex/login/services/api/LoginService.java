package com.alex.login.services.api;

import com.alex.login.dao.model.UserEntity;

/**
 * Created by alejandro on 8/20/16.
 */
public interface LoginService {

    UserEntity authenticate(UserEntity userEntity);

}
