package cz.vsmie.example.hibernate.command;

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
    ArtistCommand artistid;
    GenreCommand genreid;
    String title;
    Double price;
    String albumart;

    public AlbumCommand() {
    }

    public AlbumCommand(Integer albumid, ArtistCommand artistid, String title, Double price, String albumart) {
        this.albumid = albumid;
        this.artistid = artistid;
        this.title = title;
        this.price = price;
        this.albumart = albumart;
    }

     public Integer getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Integer albumid) {
        this.albumid = albumid;
    }

    public ArtistCommand getArtistid() {
        return artistid;
    }

    public void setArtistid(ArtistCommand artistid) {
        this.artistid = artistid;
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

    public GenreCommand getGenre() {
        return genreid;
    }

    public void setGenreid(GenreCommand genreid) {
        this.genreid = genreid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (albumid != null ? albumid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlbumCommand)) {
            return false;
        }
        AlbumCommand other = (AlbumCommand) object;
        if ((this.albumid == null && other.albumid != null) || (this.albumid != null && !this.albumid.equals(other.albumid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.MVCcdshop.Entities.Album[ albumid=" + albumid + " ]";
    }
    
    
    
}
