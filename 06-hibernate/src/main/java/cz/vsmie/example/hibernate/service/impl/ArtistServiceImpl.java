/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.service.impl;

import cz.vsmie.example.hibernate.command.ArtistCommand;
import cz.vsmie.example.hibernate.db.dao.ArtistDAO;
import cz.vsmie.example.hibernate.db.entity.Artist;
import cz.vsmie.example.hibernate.service.ArtistService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Grant
 */

@Component("artistService")
public class ArtistServiceImpl implements ArtistService{
    
    @Autowired ArtistDAO artistDAO;
    
    @Override
    public List<ArtistCommand> findAll() {

        List<ArtistCommand> artists = new ArrayList<ArtistCommand>();
        for (Artist artist : artistDAO.findAllActive()) {
            ArtistCommand artistCmd = new ArtistCommand(artist.getArtistid(), artist.getName());
            artists.add(new ArtistCommand(artist.getArtistid(), artistCmd.getName()));
        }

        return artists;
    }

    @Override
    public ArtistCommand findById(Integer artistid) {
        Artist artist = artistDAO.findById(artistid);
        if (artist == null) {
            return null;
        }
        
        ArtistCommand artistCmd = new ArtistCommand(artist.getArtistid(), artist.getName());
        return new ArtistCommand(artist.getArtistid(), artistCmd.getName());
    }

    @Override
    public void saveOrUpdate(ArtistCommand command) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
