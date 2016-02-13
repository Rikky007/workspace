/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.service;

import cz.vsmie.example.hibernate.command.AlbumCommand;
import cz.vsmie.example.hibernate.command.CartCommand;
import java.util.List;

/**
 *
 * @author Grant
 */
public interface CartService {
    
    public CartCommand findById(Integer id);
    
    public List<CartCommand> findAll();
    
    public void saveOrUpdate(CartCommand command);

    public Integer createCart();
    
    
}
