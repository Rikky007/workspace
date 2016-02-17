/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.service.impl;

import com.sun.media.sound.AlawCodec;
import cz.vsmie.example.hibernate.command.AlbumCommand;
import cz.vsmie.example.hibernate.command.CartCommand;
import cz.vsmie.example.hibernate.command.CartItemCommand;
import cz.vsmie.example.hibernate.db.dao.AlbumDAO;
import cz.vsmie.example.hibernate.db.dao.ArtistDAO;
import cz.vsmie.example.hibernate.db.dao.CartDAO;
import cz.vsmie.example.hibernate.db.dao.CartitemsDAO;
import cz.vsmie.example.hibernate.db.dao.GenreDAO;
import cz.vsmie.example.hibernate.db.entity.Album;
import cz.vsmie.example.hibernate.db.entity.Artist;
import cz.vsmie.example.hibernate.db.entity.Cartitems;
import cz.vsmie.example.hibernate.db.entity.Cart;
import cz.vsmie.example.hibernate.db.entity.Genre;
import cz.vsmie.example.hibernate.service.CartitemsService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Grant
 */
@Component("cartItemService")
public class CartItemServiceImpl implements CartitemsService {

    @Autowired private CartDAO cartDAO;
    @Autowired private CartitemsDAO cartitemsDAO;
    @Autowired private ArtistDAO artistDAO;
    @Autowired private GenreDAO genreDAO;
    @Autowired private AlbumDAO albumDAO;    
    
    @Override
    public List<CartItemCommand> findAlbumFromCartid(Integer cartid) {
        List<CartItemCommand> result = new ArrayList<CartItemCommand>();
        
        List<Cartitems> items = cartitemsDAO.findAlbumFromCartid(cartid);
        for (Cartitems item : items) {
            Album album = item.getAlbumid();
            Integer count = item.getCount();
            
            CartItemCommand cartItem = new CartItemCommand();
            AlbumCommand albumCommand = new AlbumCommand(album.getAlbumid(), album.getArtistid().getName(), album.getTitle(), album.getPrice(), album.getAlbumart());
            cartItem.setAlbum( albumCommand );
            cartItem.setCount( count );
            
            result.add(cartItem);
        }
        
        return result;
    }

    @Override
    public void addItem(CartCommand cartCmd, AlbumCommand albumCmd, Integer count) {
        Cartitems item = new Cartitems();
        Album a = albumDAO.findById( albumCmd.getAlbumid() );
        Cart c = cartDAO.findById(cartCmd.getCartid());
        Artist artist = artistDAO.findById(albumCmd.getArtistid());
        Genre genre = genreDAO.findById(albumCmd.getGenreid());
        
        /// VYtvoreni a nastaveni novych Entit
        item.setId( cartitemsDAO.findAllActive().size() + 1 );
        item.setAlbumid(a);
        item.setCartid(c);
        item.setCount(count);
        item.setDatecreated(new Date());
        
        
        cartitemsDAO.saveCartitems(item);
    }

    @Override
    public void removeItem(CartCommand cart, AlbumCommand album) {
        cartitemsDAO.deleteCartitems(Integer.SIZE);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    
}
