/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.dao;

import cz.vsmie.example.hibernate.db.entity.Artist;
import java.util.List;

/**
 *
 * @author Grant
 */
public interface ArtistDAO {
    public List<Artist> findAllActive();
    
    public Artist findById(Integer artistId);
    
    public void saveArtist(Artist a);
    
    public void updateArtist(Artist a);
    
    public void delete(Integer artistId);
    
}