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
public class ArtistCommand {
    private Integer artistid;
    private String name;

    public Integer getArtistid() {
        return artistid;
    }

    public void setArtistid(Integer artistid) {
        this.artistid = artistid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtistCommand(Integer artistid, String name) {
        this.artistid = artistid;
        this.name = name;
    }
    
}
