/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.MVCcdshop.Controllers;

import cz.MVCcdshop.Entities.Orders;
import cz.MVCcdshop.Entities.Users;
import cz.MVCcdshop.Models.OrdersModel;
import cz.MVCcdshop.Models.UsersModel;
import cz.MVCcdshop.Models.UsersroleModel;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Grant
 */

@Controller
public class UsersController {
    
    @Autowired
    private UsersModel usersModel = null;
    
    @Autowired
    private UsersroleModel usersroleModel = null;
    
    @Autowired
    private OrdersModel ordersModel = null;
    
    /**
     * Mapuje registrační stránku - GET
     * @param request
     * @return 
     */
    @RequestMapping(value ="/addUser", method = RequestMethod.GET)
    public ModelAndView addUserPageGet(HttpServletRequest request){
        
        return new ModelAndView("addUser", "usersModel", usersModel);
    }
    
    /**
     * Mapuje reg. stránku - POST
     * @param error
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value ="/addUser", method = RequestMethod.POST)
    public ModelAndView addUserPagePost(@RequestParam(value = "error",required = false)boolean error,
                                        ModelMap model, HttpServletRequest request){
        
        Users myUser = new Users();
        String myUsername, myPassword, myFirstname, myLastname;
        int myUserrole = 2;
        
        //načtení info z reg. formuláře
        myUsername = request.getParameter("txtUsername");
        myPassword = request.getParameter("txtPassword");
        myFirstname = request.getParameter("txtFirstname");
        myLastname = request.getParameter("txtLastname");
        
        if(checkUsername(myUsername)){
            
            //odeslání dat nového uživatele 
            myUser.setFirstname(myFirstname);
            myUser.setLastname(myLastname);
            myUser.setPassword(myPassword);
            myUser.setUsername(myUsername);
            
            usersModel.create(myUser);
            model.put("error", "");
            
            //načtení info z reg. formuláře
            Orders myOrders = new Orders();
            String address = request.getParameter("txtAddress");
            String city = request.getParameter("txtCity");
            String postal = request.getParameter("txtPostalCode");
            String country = request.getParameter("txtCountry");
            String phone = request.getParameter("txtPhone");
            String email = request.getParameter("txtEmail");
            Date today = new Date();
            double total = 0.00;
            
            //odeslání poštovních údajů
            myOrders.setAddress(address);
            myOrders.setCity(city);
            myOrders.setPostalcode(postal);
            myOrders.setCountry(country);
            myOrders.setPhone(phone);
            myOrders.setEmail(email);
            myOrders.setOrderdate(today);
            myOrders.setTotal(total);
            myOrders.setUserid(myUser);
            
            ordersModel.create(myOrders);
            
            return new ModelAndView("storeindex", "usersModel", usersModel);
        }else{
            model.put("error","Toto uživatelské jméno je již obsazeno");
        }
    return new ModelAndView("addUser", "usersModel", usersModel);
    }
    
    public boolean checkUsername(String passUsername){
        boolean result = true;
        
        for (Users checkUser : usersModel.findAllUsers()){
            if (checkUser.getUsername().equals(passUsername)){
                result = false;
            }
        }
        return result;
    }
}
