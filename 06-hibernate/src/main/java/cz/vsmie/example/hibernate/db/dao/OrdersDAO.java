/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.dao;

import cz.vsmie.example.hibernate.db.entity.Orders;
import java.util.List;

/**
 *
 * @author Grant
 */
public interface OrdersDAO {
    public Orders findById(Integer orderId);

    public List<Orders> findAllActive();

    public void saveOrders(Orders order);

    public void updateOrders(Orders order);

    public void delete(Integer orderId);
}
