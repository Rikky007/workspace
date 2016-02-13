/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Grant
 */
@Entity
@Table(name = "ARTIST")
public class Artist implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @Basic(optional = false)
    @Column(name = "ARTISTID")
    private Integer artistid;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;

    
//    @Transient
//    private boolean smazano = false;
//    
    
    
    public Artist() {
    }

    public Artist(Integer artistid) {
        this.artistid = artistid;
    }

    public Artist(Integer artistid, String name) {
        this.artistid = artistid;
        this.name = name;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artistid != null ? artistid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artist)) {
            return false;
        }
        Artist other = (Artist) object;
        if ((this.artistid == null && other.artistid != null) || (this.artistid != null && !this.artistid.equals(other.artistid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.MVCcdshop.Entities.Artist[ artistid=" + artistid + " ]";
    }

//    public boolean getSmazano() {
//        return smazano;
//    }
//    
//    public void setSmazano(boolean b) {
//        this.smazano = b;
//    }
    
}
