/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.dao.impl;

import cz.vsmie.example.hibernate.db.dao.CartitemsDAO;
import cz.vsmie.example.hibernate.db.entity.Album;
import cz.vsmie.example.hibernate.db.entity.Cartitems;
import java.util.ArrayList;
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
@Component("CartitemsDAO")
public class CartitemsDAOImpl implements CartitemsDAO{
    
    @Autowired SessionFactory SessionFactory;
    
    protected Session getSession(){
        return SessionFactory.getCurrentSession();
    }
    @Override
    public List<Cartitems> findAllActive() {
        Criteria c = getSession().createCriteria(Cartitems.class);
        return c.list();
    }

    
    //nutnost?
    @Override
    public List<Cartitems> findAlbumFromCartid(Integer cartId) {
        Criteria c = getSession().createCriteria(Cartitems.class);
        c.add(Restrictions.eq("cartid.cartid", cartId));
        return c.list();
    }

    @Override
    public Cartitems findById(Integer id) {
        Criteria c = getSession().createCriteria(Cartitems.class);
        c.add(Restrictions.eq("id", id));
        return (Cartitems) c.uniqueResult();
    }

    //níže si nejsem jistý :)
    
    @Override
    public void saveCartitems(Cartitems c) {
        getSession().saveOrUpdate(c);
    }

    @Override
    public void updateCartitems(Cartitems c) {
        getSession().update(c);
    }

    @Override
    public void delete(Integer itemsId) {
         Cartitems c = findById(itemsId);

        getSession().delete(c);
    }
    
}
