/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.MVCcdshop.Models;

import cz.MVCcdshop.Entities.Users;
import java.util.ArrayList;
import java.util.List;
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
@Service("userService")
public class UsersModel {
    @PersistenceContext
    private EntityManager em;
    
    /**
     * vytvoří user objekt
     * @param user 
     */
    @Transactional
    public void create(Users user){
        em.persist(user);
    }
    
    /**
     * Výpis uživatelů
     * @return 
     */
    public List<Users> findAllUsers(){
        List<Users> usersList = new ArrayList<Users>();
        
        try{
            Query q = em.createNamedQuery("Users.findAll");
            usersList = q.getResultList();
        }catch (Exception ex){
            
        }
        return usersList;
    }
    
    /**
     * hledání uživatelů
     * @param passUsername
     * @return 
     */
    public Users findUserByUsername(String passUsername){
        List<Users> usersList = null;
        
        Query q = em.createNamedQuery("Users.findByUsername");
        q.setParameter("username", passUsername);
        usersList = q.getResultList();
        
        return usersList.get(0);
    }
    
    /**
     * Ověření jména a hesla
     * @param username
     * @param password
     * @return 
     */
    public boolean verifyLoginUser(String username, String password){
        boolean result = false;
        List<Users> myUsersList = null;
        
        try{
            myUsersList = findAllUsers();
        }
        catch(Exception ex)
        {
            System.out.println("Žádný uživatel nenalezen ("+ex+")");
        }  
        for(Users myUser : myUsersList){
            if((myUser.getUsername().equals(username))&&(myUser.getPassword().equals(password)))
            {
               result = true;
            }
        }
        return result;
    }
}
