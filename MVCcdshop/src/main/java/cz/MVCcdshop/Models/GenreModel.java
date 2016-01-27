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

import cz.MVCcdshop.Entities.Genre;
/**
 *
 * @author Grant
 */

@Component
@Service("genreService")
public class GenreModel {
    
    //objekt pro práci s DB
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Vytvoøení objektu Genre
     * @param genre 
     */
    @Transactional
    public void create(Genre genre){
        em.persist(genre);
    }
    
    /**
     * výpis žánrù
     * @return 
     */
    public List<Genre> findAllGenres(){
        List<Genre> genreList= new ArrayList<Genre>();
        try{
            Query q = em.createNamedQuery("Genre.findAll");
            genreList =q.getResultList();
            
        }catch (Exception ex){
        }
        return genreList;
        
    }
    
    @SuppressWarnings("unchecked")
    public Genre findGenreById(int passId){
        List<Genre> genreList = new ArrayList<Genre>();
        
        try{
            Query q = em.createNamedQuery("Genre.findByGenreid");
            q.setParameter("genreid", passId);
            
            genreList = q.getResultList();
            
        }catch(Exception ex){
                  
        }
        return genreList.get(0);
    }
    
}
