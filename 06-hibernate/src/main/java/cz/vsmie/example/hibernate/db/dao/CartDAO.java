/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.dao;

import cz.vsmie.example.hibernate.db.entity.Album;
import cz.vsmie.example.hibernate.db.entity.Cart;
import cz.vsmie.example.hibernate.db.entity.Kategorie;

/**
 *
 * @author Grant
 */
public interface CartDAO {

    public Cart findById(Integer id);
    
    public Iterable<Cart> findAllActive();

    public void saveCart(Cart cart);
    
        public void updateCart(Cart c);

        
    
    public void delete(Long id);
    
}
