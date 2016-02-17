/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.command;

/**
 *
 * @author Grant
 */
public class CartItemCommand {
    
    AlbumCommand album;
    Integer count;

    public String getTitle() {
        return album.getTitle();
    }
    public String getArtist() {
        return album.getArtist();
    }
    public Double getPrice() {
        return album.getPrice();
    }
    public Integer getAlbumid() {
        return album.getAlbumid();
    }
    public CartItemCommand() {
    }    
    
    CartItemCommand(AlbumCommand album, Integer count) {
        this.album = album;
        this.count = count;
    }

    public AlbumCommand getAlbum() {
        return album;
    }

    public void setAlbum(AlbumCommand album) {
        this.album = album;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
    
    
}
