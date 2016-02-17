/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.service;

import cz.vsmie.example.hibernate.command.AlbumCommand;
import cz.vsmie.example.hibernate.command.CartCommand;
import cz.vsmie.example.hibernate.command.CartItemCommand;
import java.util.List;

/**
 *
 * @author Grant
 */
public interface CartitemsService {
    
    List<CartItemCommand> findAlbumFromCartid(Integer cartid);
    
    void addItem(CartCommand cart, AlbumCommand album, Integer count);//moznost1
    
    //void addItem(CartCommand cart, CartItemCommand cartItemCmd );//moznost2
    
    void removeItem(CartCommand cart, AlbumCommand album);
    
}
