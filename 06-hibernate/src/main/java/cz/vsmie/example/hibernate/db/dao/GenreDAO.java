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
    
    public Genre findById(Integer genreId);
    
    public void saveGenre(Genre g);
    
    public void updateGenre(Genre g);
    
    public void delete(Integer genreId);
    
}
