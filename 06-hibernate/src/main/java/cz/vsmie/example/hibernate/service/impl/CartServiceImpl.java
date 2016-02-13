/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.service.impl;

import cz.vsmie.example.hibernate.command.AlbumCommand;
import cz.vsmie.example.hibernate.command.CartCommand;
import cz.vsmie.example.hibernate.db.dao.AlbumDAO;
import cz.vsmie.example.hibernate.db.dao.CartDAO;
import cz.vsmie.example.hibernate.db.entity.Album;
import cz.vsmie.example.hibernate.db.entity.Cart;
import cz.vsmie.example.hibernate.service.CartService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Grant
 */

@Component("cartService")
public class CartServiceImpl implements CartService{
    
    @Autowired private CartDAO cartDAO;
    @Autowired private AlbumDAO albumDAO;
    
    @Override
    public CartCommand findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public void saveOrUpdate(CartCommand command) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Integer createCart() {
        
        Cart cart = new Cart();
        Integer id = findAll().size() + 1;
        cart.setCartid( id );
        cartDAO.saveCart(cart);
        
        return id;
        
    }

    @Override
    public List<CartCommand> findAll() {
        List<CartCommand> cartList = new ArrayList<CartCommand>();
        for (Cart cart : cartDAO.findAllActive()) {
            CartCommand cartcmd = new CartCommand(cart.getCartid(), new Date());
            cartList.add(cartcmd);
        }
        return cartList;
    }
    
    
}
