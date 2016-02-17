/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.db.dao;

import cz.vsmie.example.hibernate.db.entity.Users;

/**
 *
 * @author Grant
 */
public interface UsersDAO {
    public Users findById(Integer userId);

    public Iterable<Users> findAllActive();

    public void saveUsers(Users user);

    public void updateUsers(Users u);

    public void delete(Integer id);

}
