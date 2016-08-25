package com.alex.login.dao.impl;

import com.alex.login.dao.api.UserDao;
import com.alex.login.dao.model.UserEntity;
import org.springframework.stereotype.Repository;


/**
 * Created by alejandro on 8/22/16.
 */

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

    @Override
    public UserEntity getUserById(final Long id) {

        //List list = getHibernateTemplate().findByNamedParam("from UserEntity where id=?", new String("id"),id);

        return null;
    }

    @Override
    public UserEntity getUser(final String username, final String password) {

        //List list = getHibernateTemplate().findByNamedParam("from UserEntity where username=? and password=?", new String[]{"username", "password"}, new String[]{username,password});

        return null;
    }


}
