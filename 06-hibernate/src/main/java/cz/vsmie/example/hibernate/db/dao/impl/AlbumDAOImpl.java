/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.dao.impl;

import cz.vsmie.example.hibernate.db.dao.AlbumDAO;
import cz.vsmie.example.hibernate.db.entity.Album;
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
@Component("albumDAO")
public class AlbumDAOImpl implements AlbumDAO {

    @Autowired
    SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Album> findAllActive() {
        Criteria c = getSession().createCriteria(Album.class);
        return c.list();
    }

    @Override
    public Album findById(Integer albumId) {
        Criteria c = getSession().createCriteria(Album.class);
        c.add(Restrictions.eq("albumid", albumId));
        return (Album) c.uniqueResult();
    }

    @Override
    public void saveAlbum(Album a) {
        getSession().save(a);
    }

    @Override
    public void updateAlbum(Album a) {
        getSession().update(a);
    }

    @Override
    public void delete(Integer albumId) {
        Album a = findById(albumId);
//        a.setSmazano(true);
//        getSession().update(a);
        getSession().delete(a);
    }

}
