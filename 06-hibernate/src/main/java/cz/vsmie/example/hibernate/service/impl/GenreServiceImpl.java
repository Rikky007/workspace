/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.service.impl;

import cz.vsmie.example.hibernate.command.ArtistCommand;
import cz.vsmie.example.hibernate.command.GenreCommand;
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
    
    @Override
    public List<GenreCommand> findAll() {
        
//        List<ArtistCommand> artists = new ArrayList<ArtistCommand>();
//        for (Genre a : artistDAO.findAllActive()) {
//            Artist artist = a.getArtistid();
//            ArtistCommand artistCmd = new ArtistCommand(artist.getArtistid(), artist.getName());
//            artists.add(new ArtistCommand(a.getArtistid(), artistCmd.getName()));
//        }
//        
//        return artists;
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
