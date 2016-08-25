package com.alex.login.dao.api;

import com.alex.login.dao.model.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by alejandro on 8/22/16.
 */
@Repository
public interface UserDao {

    UserEntity getUserById(Long id);

    UserEntity getUser(String username, String password);

}
