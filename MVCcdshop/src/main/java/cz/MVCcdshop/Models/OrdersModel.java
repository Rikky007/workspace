/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.MVCcdshop.Models;

import cz.MVCcdshop.Entities.Orders;
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
@Service("orderService")
public class OrdersModel {
    
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    public void create(Orders orders){
        em.persist(orders);
    }
    
    /**
     * Výpis všech objednávek
     * @return 
     */
    @SuppressWarnings("unchecked")
    public List<Orders> findAllOrders(){
        List<Orders> ordersList = new ArrayList<>();
        
        try{
            Query q = em.createNamedQuery("Orders.findAll");
            ordersList = q.getResultList();
        }catch(Exception ex){
            
        }
        return ordersList;
    }
    
    /**
     * Hledání objednávek podle ID
     * @param passId
     * @return 
     */
    public Orders findOrdersByOrderId(int passId){
        
        List<Orders> ordersList =null;
        Query q = em.createNamedQuery("Orders.findByOrderid");
        q.setParameter("orderid",passId);
        if (!q.getResultList().isEmpty()){
           ordersList = q.getResultList();
           return ordersList.get(0);
           
        }else{
            return null;
        }
    }
    
}
