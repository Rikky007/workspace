/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.MVCcdshop.Controllers;

import cz.MVCcdshop.Entities.Album;
import cz.MVCcdshop.Entities.Cart;
import cz.MVCcdshop.Entities.Users;
import cz.MVCcdshop.Models.AlbumModel;
import cz.MVCcdshop.Models.CartModel;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Grant
 */

@Controller
public class CartController {
    
    @Resource(name="albumService") 
    private AlbumModel albumModel;
    
    @Resource(name = "cartService")
    private CartModel cartModel;
    
    @RequestMapping( value ="/ShoppingCart", method = RequestMethod.GET)
    public String getShoppingCartPage(@RequestParam(value="deleteAlbumID",required=false) Integer deletedAlbumID, HttpServletRequest request,
            HttpSession session, ModelMap model){
        
        //formátování decimální hodnoty
        NumberFormat formatter = new DecimalFormat("#");
        
        //připrava proměnných a objektů
        Album myAlbum = null;
        Cart myCart = new Cart();
        
        String totalPrice ="";
        
        //ověření požadavku na smazání z košíku
        if(deletedAlbumID!=null){
            Album removedAlbum = albumModel.findAlbumById(deletedAlbumID);
            deleteThatAlbum(removedAlbum);
            model.addAttribute("removedAlbumInfo", removedAlbum.getTitle()+"");
            
        }
        //vytvoření nového košíku
        else{
            cartModel.generateCartId();
            
            int addedAlbumId = (Integer) request.getSession().getAttribute("addedAlbumId");
            myAlbum = albumModel.findAlbumById(addedAlbumId);
            
            cartModel.getAlbumsInCart().add(myAlbum);
        }
    //naformátování ceny
    totalPrice = formatter.format(cartModel.getTotalPrice());
    
    //předání informací do view
    model.addAttribute("totalPrice", totalPrice);
    model.addAttribute("albumList", cartModel.getAlbumsInCart());
    model.addAttribute("myCart",myCart);
    
    return("ShoppingCart");
    }
    
    /**
     * Mapuje Košík - post
     * @param deletedAlbumID
     * @param myCart
     * @param model
     * @return 
     */
    @RequestMapping(value = "/ShoppingCart", method = RequestMethod.POST)
    public String setShoppingCartPage(@RequestParam(value ="deleteAlbumID", required=false)Integer deletedAlbumID,@ModelAttribute("myCart")Cart myCart,ModelMap model){
        model.addAttribute("myCartid", cartModel.getCurrentCartNumber());
        
        Users tempUsers = new Users();
        model.addAttribute("login", tempUsers);
        
        return "loginpage";
    
    
    }
    /**
         * Odebrání alba z košíku
         * @param album 
         */
        public void deleteThatAlbum(Album album){
            cartModel.getAlbumsInCart().remove(album);
        }
}
