package com.emp.employee.dao;

import com.emp.employee.models.dto.BaseDTO;
import com.emp.employee.models.entities.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAO<T extends BaseEntity> {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Class<T> entityType;

    public BaseDAO() {
        entityType = null;
    }

    public BaseDAO(Class<T> entityType) {
        this.entityType = entityType;
    }


    protected void saveOrUpdate(T entity) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    protected T loadByID(long id) {
        Session session = sessionFactory.openSession();
        T entity = null;
        try {
            entity = (T) session.get(entityType, id);
        } finally {
            session.close();
        }
        return entity;
    }


}
