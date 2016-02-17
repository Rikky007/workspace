/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.dao.impl;

import cz.vsmie.example.hibernate.db.dao.UsersDAO;
import cz.vsmie.example.hibernate.db.entity.Users;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Grant
 */
@Transactional
@SuppressWarnings("unchecked")
@Component("usersDAO")

public class UsersDAOImpl implements UsersDAO{
    @Autowired SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public List<Users> findAllActive(){
        Criteria c = getSession().createCriteria(Users.class);
        return c.list();
    }
    
    @Override
    public Users findById(Integer usersId){
        Criteria c = getSession().createCriteria(Users.class);
        c.add(Restrictions.eq("usersid", usersId));
        return (Users) c.uniqueResult();
    }

    @Override
    public void saveUsers(Users user) {
        getSession().save(user);
    }

    @Override
    public void updateUsers(Users user) {
        getSession().update(user);
    }

    @Override
    public void delete(Integer userId) {
        Users u = findById(userId);
        getSession().delete(u);
    }
    
}
