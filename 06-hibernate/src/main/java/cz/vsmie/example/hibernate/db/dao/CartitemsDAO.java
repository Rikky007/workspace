/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.dao;

import cz.vsmie.example.hibernate.db.entity.Cartitems;
import java.util.List;

/**
 *
 * @author Grant
 */
public interface CartitemsDAO {
    
    public List<Cartitems> findAllActive();
    
    public Cartitems findById(Integer artistId);
    
    public void saveCartitems(Cartitems c);
    
    public void updateCartitems(Cartitems c);
    
    public void delete(Integer artistId);
    
    public void findAlbum(Integer cartId);
    
}
