/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Grant
 */

@Entity
public class Cartitems implements Serializable{
    private static final long serialVersionUID  = 1L;
    
    private Integer id;
    private Cart cartid;
    private Album albumid;
    private Integer count;
    private Date datecreated = new Date();
    
    public Cartitems(){
        
    }
    
    @Id
    @Column(name="ID", unique=true,nullable=false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @JoinColumn(name = "CARTID", referencedColumnName="CARTID")
    @ManyToOne(optional=false)
    public Cart getCartid() {
        return cartid;
    }

    public void setCartid(Cart cartid) {
        this.cartid = cartid;
    }
    
    @JoinColumn(name = "ALBUMID", referencedColumnName="ALBUMID")
    @ManyToOne(optional=false)
    public Album getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Album albumid) {
        this.albumid = albumid;
    }
    
    @Basic(optional = false)
    @Column(name = "COUNT")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
    @Basic(optional = false)
    @Column(name = "DATECREATED")
    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }
    
    
}
