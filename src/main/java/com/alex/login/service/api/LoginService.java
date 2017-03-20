package com.alex.login.service.api;

import com.alex.login.dao.entities.UserEntity;
import com.alex.login.service.exceptions.UserAuthenticationExeption;

/**
 * Created by alejandro on 8/20/16.
 */
public interface LoginService {

    UserEntity authenticate(final UserEntity userEntity) throws UserAuthenticationExeption;

}
