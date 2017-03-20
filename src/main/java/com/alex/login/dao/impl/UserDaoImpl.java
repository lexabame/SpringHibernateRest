package com.alex.login.dao.impl;

import com.alex.login.dao.api.UserDao;
import com.alex.login.dao.entities.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by alejandro on 8/22/16.
 */

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

    @Override
    public UserEntity getUserById(final Long id) {
        return (UserEntity) getSessionFactory().getCurrentSession().load(UserEntity.class, id);
    }

    @Override
    public UserEntity getUser(final String username, final String password) {
        /*Criteria cr = getSessionFactory().getCurrentSession().createCriteria(UserEntity.class);
        cr.add(Restrictions.eq("username", username));
        cr.add(Restrictions.eq("password", password));
        List results = cr.list();
        return (UserEntity) results.get(0);*/


        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT  ue from UserEntity ue WHERE username = :username AND password = :password");

        query.setParameter("username", username);
        query.setParameter("password", password);

        List<UserEntity> users = query.list();

        return users.get(0);
    }

    @Override
    public List<UserEntity> getUsers() {
        Query query = getSessionFactory().getCurrentSession().createQuery("from UserEntity u");
        return query.list();
    }

    @Override
    public UserEntity getUserByEmail(final String email) {

        UserEntity userEntity = (UserEntity) getSessionFactory().getCurrentSession()
                .createCriteria(UserEntity.class, "user")
                .createAlias("user.account", "account")
                .add(Restrictions.eq("account.email", email)).list().get(0);
        return userEntity;


    }

    @Override
    public void addUser(final UserEntity userEntity) {
        getSessionFactory().getCurrentSession().save(userEntity);
    }


}
