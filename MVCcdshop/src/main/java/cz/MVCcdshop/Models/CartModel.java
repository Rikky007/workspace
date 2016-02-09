/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.MVCcdshop.Models;

import cz.MVCcdshop.Entities.Album;
import cz.MVCcdshop.Entities.Cart;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Grant
 */

@Component
@Service("cartService")
public class CartModel {
    private Integer currentCartNumber = 0;
    public List<Album> albumInCart = new ArrayList<Album>();
    
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    public void create (Cart cart){
        em.merge(cart);
    }
    /**
     * Vymazání košíku z databáze
     * @param cart 
     */
    @Transactional
    public void delete(Cart cart){
        em.remove(cart);
    }
    
    /**
     * generování ID
     */
    public void generateCartId(){
        if(currentCartNumber==0){
            Random rand = new Random();
            currentCartNumber = rand.nextInt(999999999);
        }
    }
    
    /**
     * Vyhledání košíku dle ID
     * @param passId
     * @return 
     */
    public List<Cart> findCartById(Integer passId){
        List<Cart> cartList = null;
        
        Query q = em.createNamedQuery("Cart.findByCartid");
        q.setParameter("cartid",passId);
        cartList = q.getResultList();
        
        return cartList;
    }
    
    /**
     * Celková cena košíku
     * @return 
     */
    public double getTotalPrice(){
        double price = 0;
        List<Album>albumList = getAlbumsInCart();
        
        for(Album myAlbum : albumList){
            price+=myAlbum.getPrice();
        }
        return price;
    }
            
    public void deleteAlbumFromAlbumList(Album myAlbum){
        getAlbumsInCart().remove(myAlbum);
    }
    
    public Integer getCurrentCartNumber(){
        return currentCartNumber;
    }
}
