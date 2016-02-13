/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.dao.impl;

import cz.vsmie.example.hibernate.db.dao.ArtistDAO;
import cz.vsmie.example.hibernate.db.entity.Album;
import cz.vsmie.example.hibernate.db.entity.Artist;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Grant
 */
@Transactional
@Component("artistDAO")
public class ArtistDAOImpl implements ArtistDAO {

    @Autowired SessionFactory sessionFactory;
    
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public List<Artist> findAllActive() {
        Criteria c = getSession().createCriteria(Artist.class);
        return c.list();
    }
    
    @Override
    public Artist findById(Integer artistId) {
        Criteria c = getSession().createCriteria(Album.class);
        c.add(Restrictions.eq("artistid", artistId));
        return (Artist) c.uniqueResult();
    }

    @Override
    public void saveArtist(Artist a) {
        getSession().save(a);
    }

    @Override
    public void updateArtist(Artist a) {
        getSession().update(a);
    }

    @Override
    public void delete(Integer artistId) {
        Artist a = findById(artistId);
//        a.setSmazano(true);
        getSession().delete(a);
//        getSession().update(a);
    }
    
}
