/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.service.impl;

import cz.vsmie.example.hibernate.command.AlbumCommand;
import cz.vsmie.example.hibernate.command.CartCommand;
import cz.vsmie.example.hibernate.command.CartItemCommand;
import cz.vsmie.example.hibernate.db.dao.ArtistDAO;
import cz.vsmie.example.hibernate.db.dao.CartitemsDAO;
import cz.vsmie.example.hibernate.db.entity.Album;
import cz.vsmie.example.hibernate.db.entity.Artist;
import cz.vsmie.example.hibernate.db.entity.Cartitems;
import cz.vsmie.example.hibernate.db.entity.Cart;
import cz.vsmie.example.hibernate.service.CartitemsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Grant
 */
@Component("cartItemService")
public class CartItemServiceImpl implements CartitemsService {

    @Autowired private CartitemsDAO cartitemsDAO;
    @Autowired private ArtistDAO artistDAO;
    
    @Override
    public List<CartItemCommand> findAlbumFromCartid(Integer cartid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addItem(CartCommand cartCmd, AlbumCommand albumCmd, Integer count) {
        Cartitems item = new Cartitems();
        Album a = new Album();
        Cart c = new Cart();
        Artist artist = artistDAO.findById(albumCmd.getArtistid());
        
        /// VYtvoreni a nastaveni novych Entity
        a.setAlbumart(albumCmd.getAlbumart());
        a.setArtistid(artist);
        a.setArtistid();
        
        
        
        
        item.setAlbumid(a);
        item.setCartid(c);
        item.setCount(count);
        item.setDatecreated(new Date());
        
        cartitemsDAO.saveCartitems(item);
    }

    @Override
    public void addItem(CartCommand cart, CartItemCommand cartItemCmd) {
        Cartitems item = new Cartitems();
        item.setAlbumid(cartItemCmd.getAlbum().getAlbumid());
        item.setCartid(cart.getCartid());
        item.setCount(cartItemCmd.getCount());
        item.setDatecreated(new Date());
        
        cartitemsDAO.saveCartitems(item);
    
    }
    
    
    
}
