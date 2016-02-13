/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Grant
 */

@Entity
@Table(name = "CART")
public class Cart implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Integer cartid;
    
    public Cart(){
        
    }
    
    
    @Id
    @Column(name = "CARTID", unique = true, nullable=false)
    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }
    
    
    
}
