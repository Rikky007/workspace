/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.controller;

import cz.vsmie.example.hibernate.command.AlbumCommand;
import cz.vsmie.example.hibernate.command.CartCommand;
import cz.vsmie.example.hibernate.command.CartItemCommand;
import cz.vsmie.example.hibernate.service.AlbumService;
import cz.vsmie.example.hibernate.service.CartService;
import cz.vsmie.example.hibernate.service.CartitemsService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @Autowired
    private AlbumService albumService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CartitemsService cartItemService;

    @RequestMapping(method = RequestMethod.GET, value = "/show-cart.htm")
    public String showCart(Model model,
            HttpSession session, HttpServletRequest request) {
        Integer cartid = (Integer) session.getAttribute("cartid");
        if (cartid == null) {

            cartid = cartService.createCart();
            session = request.getSession(); //vytvoreni session
            session.setAttribute("cartid", cartid);
        }

        CartCommand cartCommand = cartService.findById(cartid);
        List<CartItemCommand> cartItems = cartItemService.findAlbumFromCartid(cartid);
        model.addAttribute("items", cartItems);
        return "show-cart";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add-to-cart.htm")
    public String addToCart(Model model,
            @RequestParam("id") Integer albumid,
            HttpSession session,
            HttpServletRequest request) {

        Integer cartid = (Integer) session.getAttribute("cartid");
        if (cartid == null) {

            cartid = cartService.createCart();
            session = request.getSession(); //vytvoreni session
            session.setAttribute("cartid", cartid);
            Integer counter = 1;
            session.setAttribute("counter", counter);
        }

        CartCommand cartCommand = cartService.findById(cartid);
        AlbumCommand albumCommand = albumService.findById(albumid);

        cartItemService.addItem(cartCommand, albumCommand, 1);
        Integer counter = (Integer) session.getAttribute("counter");
        counter++;
        
        model.addAttribute("counter", counter);
        model.addAttribute("cartid",cartCommand );
        return "redirect:album-list.htm";
    }

 

    @RequestMapping(method = RequestMethod.GET, value = "/remove-album.htm")
    public String removeFromCart(Model model,
            @RequestParam("id") Integer albumId,
            @ModelAttribute("cartCommand") CartCommand cartCommand,
            BindingResult errors) {

        

        return "redirect:show-cart";
    }

}
