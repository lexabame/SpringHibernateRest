package com.alex.login.dao.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Created by alejandro on 8/25/16.
 */
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractDao {

    @Autowired
    protected @Getter SessionFactory sessionFactory;

}
