package com.alex.login.dao.api;

import com.alex.login.dao.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alejandro on 8/22/16.
 */
@Repository
public interface UserDao {

    UserEntity getUserById(final Long id);

    List<UserEntity> getUsers();

    UserEntity getUserByEmail(final String email);

    void addUser(final UserEntity userEntity);

    void updateUser(final UserEntity userEntity);

    void deleteUser(final UserEntity userEntity);

}
