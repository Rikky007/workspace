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

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.MVCcdshop.Entities.Artist;
/**
 *
 * @author Grant
 */

@Component
@Service("artistService")
public class ArtistModel {
    
    //objekt pro práci s DB
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Vytvoření objektu Artist
     * @param artist 
     */
    @Transactional
    public void create(Artist artist){
        em.persist(artist);
    }
    
    /**
     * výpis žánru
     * @return 
     */
    public List<Artist> findAllArtists(){
        List<Artist> genreList= new ArrayList<>();
        try{
            Query q = em.createNamedQuery("Artist.findAll");
            genreList =q.getResultList();
            
        }catch (Exception ex){
        }
        return genreList;
        
    }
    
    /**
     * Výpis žánru podle ID
     * @param passId
     * @return 
     */
    @SuppressWarnings("unchecked")
    public Artist findArtistById(int passId){
        List<Artist> artistList = new ArrayList<>();
        
        try{
            Query q = em.createNamedQuery("Artist.findByArtistid");
            q.setParameter("genreid", passId);
            
            artistList = q.getResultList();
            
        }catch(Exception ex){
                  
        }
        return artistList.get(0);
    }
    
}