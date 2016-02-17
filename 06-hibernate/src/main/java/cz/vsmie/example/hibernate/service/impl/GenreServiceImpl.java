/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.service.impl;

import cz.vsmie.example.hibernate.command.ArtistCommand;
import cz.vsmie.example.hibernate.command.GenreCommand;
import cz.vsmie.example.hibernate.db.dao.ArtistDAO;
import cz.vsmie.example.hibernate.db.dao.GenreDAO;
import cz.vsmie.example.hibernate.db.entity.Genre;
import cz.vsmie.example.hibernate.db.entity.Artist;
import cz.vsmie.example.hibernate.service.GenreService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Grant
 */
@Component("genreService")
public class GenreServiceImpl implements GenreService{
    
    @Autowired GenreDAO genreDAO;
    @Autowired ArtistDAO artistDAO;
    
    @Override
    public List<GenreCommand> findAll() {
        
        List<GenreCommand> genres = new ArrayList<GenreCommand>();
        for (Genre genre : genreDAO.findAllActive()) {
            GenreCommand genreCmd = new GenreCommand(genre.getGenreid(), genre.getName());
            genres.add(new GenreCommand(genre.getGenreid(), genreCmd.getName()));
        }

        return genres;
    }
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    

    @Override
    public GenreCommand findById(Integer idKategorie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveOrUpdate(GenreCommand command) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
