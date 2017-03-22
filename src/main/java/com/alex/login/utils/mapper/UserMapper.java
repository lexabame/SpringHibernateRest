package com.alex.login.utils.mapper;

import com.alex.login.dao.entities.UserEntity;
import com.alex.login.remoting.rest.data.UserCanonical;
import org.springframework.stereotype.Component;

/**
 * Created by alejandro on 3/20/17.
 */

@Component
public class UserMapper extends MapperImpl<UserEntity, UserCanonical> {

    public UserMapper() {
        super(UserEntity.class, UserCanonical.class);
    }

}
