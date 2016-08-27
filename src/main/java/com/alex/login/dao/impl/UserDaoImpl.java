package com.alex.login.dao.impl;

import com.alex.login.dao.api.UserDao;
import com.alex.login.dao.model.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by alejandro on 8/22/16.
 */

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

    @Override
    public UserEntity getUserById(final Long id) {

        return getHibernateTemplate().get(UserEntity.class, id);

    }

    @Override
    public UserEntity getUser(final String username, final String password) {

        List users = getHibernateTemplate().findByNamedParam("FROM UserEntity u WHERE u.username = :username AND u.password = :password", new String[]{"username", "password"}, new String[]{username, password});

        return (UserEntity) users.get(0);

    }


}
