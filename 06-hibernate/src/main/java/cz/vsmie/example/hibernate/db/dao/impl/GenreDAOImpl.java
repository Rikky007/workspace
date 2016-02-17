/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.dao.impl;

import cz.vsmie.example.hibernate.db.dao.GenreDAO;
import cz.vsmie.example.hibernate.db.entity.Genre;
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
@Component("genreDAO")
public class GenreDAOImpl implements GenreDAO{

    
    @Autowired
    SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    
    @Override
    public List<Genre> findAllActive() {
        Criteria c = getSession().createCriteria(Genre.class);
        return c.list();
    }
    
    @Override
    public Genre findById(Integer genreId) {
        Criteria c = getSession().createCriteria(Genre.class);
        c.add(Restrictions.eq("genreid", genreId));
        return (Genre) c.uniqueResult();
    }

    @Override
    public void saveGenre(Genre g) {
        getSession().save(g);
    }

    @Override
    public void updateGenre(Genre g) {
        getSession().update(g);
    }

    @Override
    public void delete(Integer artistId) {
        Genre g = findById(artistId);
//        a.setSmazano(true);
        getSession().delete(g);
//        getSession().update(a);
    }
    
}
