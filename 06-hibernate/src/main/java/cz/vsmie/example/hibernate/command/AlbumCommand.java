package cz.vsmie.example.hibernate.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Trida reprezentuje formular pro pridani/editaci kategorie. V html
 * vyrenderovanem v prohlizeci najdeme input typu hidden s atributem
 * name=idAlbum, input typu text s atributem name=nazev a textareu s atributem
 * name=popis
 *
 * @author Ing. Jiří Franc
 */
public class AlbumCommand {

    Integer albumid;
    
    Integer artistid;
    Integer genreid;
        
    String artist;
    String genre;
    
    
    String title;
    Double price;
    String albumart;

    List<ArtistCommand> artists;
    
    List<GenreCommand> genres;
   
    
    public AlbumCommand(){}
    

    
    public AlbumCommand(Integer albumid, String artist, String title, Double price, String albumart) {
        this.albumid = albumid;
        this.artist = artist;
        this.title = title;
        this.price = price;
        this.albumart = albumart;
        
        artists = new ArrayList<ArtistCommand>();
        genres  = new ArrayList<GenreCommand>();
        
    }

     public Integer getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Integer albumid) {
        this.albumid = albumid;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artistid) {
        this.artist = artistid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAlbumart() {
        return albumart;
    }

    public void setAlbumart(String albumart) {
        this.albumart = albumart;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenreid(String genre) {
        this.genre = genre;
    }   
        public Integer getArtistid() {
        return artistid;
    }

    public void setArtistid(Integer artistid) {
        this.artistid = artistid;
    }

    public Integer getGenreid() {
        return genreid;
    }

    public void setGenreid(Integer genreid) {
        this.genreid = genreid;
    }

    public List<ArtistCommand> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistCommand> artists) {
        this.artists = artists;
    }

    public List<GenreCommand> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreCommand> genres) {
        this.genres = genres;
    }

    
    
}
