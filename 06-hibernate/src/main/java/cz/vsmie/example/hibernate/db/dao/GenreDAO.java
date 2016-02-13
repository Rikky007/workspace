/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.dao;

import cz.vsmie.example.hibernate.db.entity.Genre;
import java.util.List;

/**
 *
 * @author Grant
 */
public interface GenreDAO {
   public List<Genre> findAllActive();
    
    public Genre findById(Integer artistId);
    
    public void saveGenre(Genre a);
    
    public void updateGenre(Genre a);
    
    public void delete(Integer artistId);
    
}
