/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.command;

import cz.vsmie.example.hibernate.db.entity.Cart;
import cz.vsmie.example.hibernate.db.entity.Users;
import java.util.Date;

/**
 *
 * @author Grant
 */
public class OrdersCommand {
    private Integer orderid;
    private String address;
    private Date orderdate;
    private String city;
    private String postalcode;
    private String country;
    private String phone;
    private String email;
    private Double total;
    private Users userid;
    private Cart cartid;

    public OrdersCommand() {
    }

    public OrdersCommand(Integer orderid) {
        this.orderid = orderid;
    }

    public OrdersCommand(Integer orderid, Date orderdate, Double total) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.total = total;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

 
    public Cart getCartid() {
        return cartid;
    }

    public void setCartid(Cart cartid) {
        this.cartid = cartid;
    }


    
}
