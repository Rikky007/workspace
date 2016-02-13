/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.command;

import cz.vsmie.example.hibernate.db.entity.Album;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
 
/*
 * @author Grant
 */
public class CartCommand {
    private Integer cartid;
    private Date datecreated;

    Map<AlbumCommand, Integer> albums = new Hashtable<AlbumCommand, Integer>();

    public void addAlbum(AlbumCommand album) {
        Integer count = albums.get(album);
        if (count == null) count = 0;
        albums.put(album, ++count);
    }
    
    public void removeAlbum(AlbumCommand album) {
        if (!albums.containsKey(album)) return;
        
        albums.remove(album);
    }
    
    public CartCommand() {
    }

    public CartCommand(Integer cartid) {
        this.cartid = cartid;
    }

    public CartCommand(Integer cartid, Date datecreated) {
        this.cartid = cartid;
        this.datecreated = datecreated;
    }

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Integer getCount(Album album) {
        return albums.get(album);
    }
    
    public List<CartItemCommand> getCartItems() {
        List<CartItemCommand> cartItems = new ArrayList<CartItemCommand>();
        for (Map.Entry<AlbumCommand, Integer> entry : albums.entrySet()) {
            AlbumCommand album = entry.getKey();
            Integer count = entry.getValue();
            CartItemCommand cartItem = new CartItemCommand(album, count);
            cartItems.add(cartItem);
        }
        
        return cartItems;
    }
    
}
