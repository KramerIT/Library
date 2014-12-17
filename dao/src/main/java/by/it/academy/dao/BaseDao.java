/*
 * Copyright (C) 2014 GHX, Inc.
 *  Louisville, Colorado, USA.
 *  All rights reserved.
 *
 *  Warning: Unauthorized reproduction or distribution of this program, or
 *  any portion of it, may result in severe civil and criminal penalties,
 *  and will be prosecuted to the maximum extent possible under the law.
 *
 *  Created on 020 20.06.2014
 */
package by.it.academy.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

@Repository
public class BaseDao<T> implements Dao<T> {
    private static Logger log = Logger.getLogger(BaseDao.class);

    private Class<T> getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory = null;

    public BaseDao() {
    }

    @Autowired
    public BaseDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(T t) {
        getSession().saveOrUpdate(t);
        log.info("Save:" + t);
    }

    @Override
    public void update(T t) {
        getSession().update(t);
        log.info("Update:" + t);
    }

/*    @Override
    public T get(Class<T> clazz, Serializable id) {
        log.info("Get:" + id);
        return (T) getSession().load(clazz, id);
    }
*/

    @Override
    public T get(Serializable id) {
        log.info("Get:" + id);
        return (T) getSession().get(getPersistentClass(), id);
    }


    @Override
    public void delete(T t) {
        log.info("Delete:" + t);
        getSession().delete(t);
    }

    @Override
    public void refresh(T t) {
        log.info("Refresh:" + t);
        getSession().refresh(t);
    }

}
