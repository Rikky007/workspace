/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.dao.impl;

import cz.vsmie.example.hibernate.db.dao.CartDAO;
import cz.vsmie.example.hibernate.db.entity.Album;
import cz.vsmie.example.hibernate.db.entity.Cart;
import cz.vsmie.example.hibernate.db.entity.Kategorie;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Grant
 */
@Transactional
@SuppressWarnings("unchecked")
@Component("cartDAO")
public class CartDAOImpl implements CartDAO {

    @Autowired
    SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Iterable<Cart> findAllActive() {
        Criteria c = getSession().createCriteria(Cart.class);
        return c.list();
    }

    @Override
    public void saveCart(Cart cart) {
        getSession().save(cart);
    }

    @Override
    public Cart findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCart(Cart c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
