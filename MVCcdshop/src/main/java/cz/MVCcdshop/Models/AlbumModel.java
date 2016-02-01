/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.MVCcdshop.Models;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.MVCcdshop.Entities.Album;


/**
 *
 * @author Grant
 */

@Component
@Service("albumService")
public class AlbumModel {
    
    //objekt pro práci s DB
    @PersistenceContext
    private EntityManager em;
    
    @Resource(name="genreService")
    private AlbumModel genreModel;
    
    @Resource(name="artistService")
    private ArtistModel artistModel;
    
    
      /**
     * Vytvoøení objektu Album
     * @param album 
     */
    @Transactional
    public void create(Album album){
        em.persist(album);
    }
    
      /**
     * výpis alb
     * @return 
     */
    public List<Album> findAllAlbums(){
        List<Album> albumList = null;
        Query q = em.createNamedQuery("Album.findAll");
        albumList =q.getResultList();
        
        return albumList;
        
    }
    
    /**
     * Výpis alb podle ID
     * @param passId
     * @return 
     */
    @SuppressWarnings("unchecked")
    public Album findAlbumById(int passId){
        List<Album> albumList = null;
        Query q = em.createNamedQuery("Album.findByAlbumid");
        q.setParameter("albumid", passId);
            
        albumList = q.getResultList();
        return albumList.get(0);
    }
}
