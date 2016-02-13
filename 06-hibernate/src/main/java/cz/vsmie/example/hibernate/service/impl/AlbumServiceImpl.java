/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.service.impl;

import cz.vsmie.example.hibernate.service.AlbumService;
import cz.vsmie.example.hibernate.command.AlbumCommand;
import cz.vsmie.example.hibernate.db.dao.AlbumDAO;
import cz.vsmie.example.hibernate.db.dao.ArtistDAO;
import cz.vsmie.example.hibernate.db.entity.Album;
import cz.vsmie.example.hibernate.db.entity.Artist;
import cz.vsmie.example.hibernate.command.ArtistCommand;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Grant
 */
@Component("albumService")
public class AlbumServiceImpl implements AlbumService {

    @Autowired AlbumDAO albumDAO;
    @Autowired ArtistDAO artistDAO;

    @Override
    public List<AlbumCommand> findAll() {
        List<AlbumCommand> albums = new ArrayList<AlbumCommand>();
        for (Album a : albumDAO.findAllActive()) {
            Artist artist = a.getArtistid();
            ArtistCommand artistCmd = new ArtistCommand(artist.getArtistid(), artist.getName());
            albums.add(new AlbumCommand(a.getAlbumid(), artistCmd.getName(), a.getTitle(), a.getPrice(), a.getAlbumart()));
        }
        
        return albums;
    }

    @Override
    public AlbumCommand findById(Integer id) {
        Album a = albumDAO.findById(id);
        if (a == null) {
            return null;
        }
        
        Artist artist = a.getArtistid();
        ArtistCommand artistCmd = new ArtistCommand(artist.getArtistid(), artist.getName());
        return new AlbumCommand(a.getAlbumid(), artistCmd.getName(), a.getTitle(), a.getPrice(), a.getAlbumart());
    }

    @Override
    public void saveOrUpdate(AlbumCommand command) {
        Album a = new Album();
        a.setTitle(command.getTitle());
        //TODO
        Artist artist = artistDAO.findById(command.getArtistid()) ;
       
        a.setArtistid( artist );  
        
    }

    @Override
    public void delete(Integer id) {
        albumDAO.delete(id);
    }

}
