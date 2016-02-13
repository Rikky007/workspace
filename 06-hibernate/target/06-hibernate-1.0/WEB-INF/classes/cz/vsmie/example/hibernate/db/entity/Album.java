/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.entity;

import java.io.Serializable;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
//import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Grant
 */
@Entity
@Table(name = "ALBUM")
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "ALBUMID", unique = true, nullable=false)
    private Integer albumid;
    
    @JoinColumn(name = "ARTISTID", referencedColumnName = "ARTISTID")
    @ManyToOne(optional = false)
    private Artist artistid;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private Double price;
    @Basic(optional = false)
    @Column(name = "ALBUMART")
    private String albumart;
    
    @JoinColumn(name = "GENREID", referencedColumnName = "GENREID")
    @ManyToOne(optional = false)
    private Genre genreid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "albumid")
    private Collection<Orderdetail> orderdetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "albumid")
    private Collection<Cart> cartCollection;

//    private boolean smazano;
//
//    @Transient
//    public boolean getSmazano() {
//        return smazano;
//    }
    
    public Album() {
    }

    public Album(Integer albumid) {
        this.albumid = albumid;
    }

    public Album(Integer albumid, Artist artistid, String title, Double price, String albumart) {
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

    public Artist getArtistid() {
        return artistid;
    }

    public void setArtistid(Artist artistid) {
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

    public Genre getGenreid() {
        return genreid;
    }

    public void setGenreid(Genre genreid) {
        this.genreid = genreid;
    }

    @XmlTransient
//    @JsonIgnore
    public Collection<Orderdetail> getOrderdetailCollection() {
        return orderdetailCollection;
    }

    public void setOrderdetailCollection(Collection<Orderdetail> orderdetailCollection) {
        this.orderdetailCollection = orderdetailCollection;
    }

    @XmlTransient
//    @JsonIgnore
    public Collection<Cart> getCartCollection() {
        return cartCollection;
    }

    public void setCartCollection(Collection<Cart> cartCollection) {
        this.cartCollection = cartCollection;
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
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.albumid == null && other.albumid != null) || (this.albumid != null && !this.albumid.equals(other.albumid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.MVCcdshop.Entities.Album[ albumid=" + albumid + " ]";
    }

//    public void setSmazano(boolean b) {
//        this.smazano = b;
//    }
    
}
