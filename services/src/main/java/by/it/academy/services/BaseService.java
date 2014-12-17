/*
 * Copyright (C) 2014 GHX, Inc.
 *  Louisville, Colorado, USA.
 *  All rights reserved.
 *
 *  Warning: Unauthorized reproduction or distribution of this program, or
 *  any portion of it, may result in severe civil and criminal penalties,
 *  and will be prosecuted to the maximum extent possible under the law.
 *
 *  Created on 023 23.06.2014
 */
package by.it.academy.services;

import by.it.academy.dao.BaseDao;
import by.it.academy.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;

@Service
@Transactional
public class BaseService<T> implements IService<T> {

    private BaseDao<T> baseDao;

    public BaseService() {
    }

    @Autowired
    public BaseService(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public void add(T t) {
        baseDao.add(t);
    }

    @Override
    public void update(T t) {
        baseDao.update(t);
    }

/*    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public T get(Class<T> clazz, Serializable id) {
        return baseDao.get(clazz, id);
    }*/

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public T get(Serializable id) {
        return baseDao.get(id);
    }

    @Override
    public void delete(T t) {
        baseDao.delete(t);
    }

    @Override
    public void refresh(T t) {
        baseDao.refresh(t);
    }
}
