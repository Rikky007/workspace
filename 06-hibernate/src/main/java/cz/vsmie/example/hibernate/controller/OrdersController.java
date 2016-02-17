/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.controller;

import cz.vsmie.example.hibernate.service.CartService;
import cz.vsmie.example.hibernate.service.GenreService;
import cz.vsmie.example.hibernate.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Grant
 */
public class OrdersController {
    @Autowired private CartService cartService;
    @Autowired private OrdersService orderService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/order-list.htm")
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "order-list";
    }

}
