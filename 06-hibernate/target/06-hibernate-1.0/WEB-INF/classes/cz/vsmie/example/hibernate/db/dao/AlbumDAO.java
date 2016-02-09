/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.dao;

import cz.vsmie.example.hibernate.db.entity.Album;
import java.util.List;

/**
 *
 * @author Grant
 */
public interface AlbumDAO {
    
    public List<Album> findAllActive();
    
    public Album findById(Long albumId);
    
    public void saveAlbum(Album a);
    
    public void updateAlbum(Album a);
    
    public void delete(Long albumId);
    
}
