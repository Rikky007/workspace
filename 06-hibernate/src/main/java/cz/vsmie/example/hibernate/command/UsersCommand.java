/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.command;

import cz.vsmie.example.hibernate.db.entity.Usersrole;

/**
 *
 * @author Grant
 */

public class UsersCommand {
    
    private Integer userid;
    private String username;
    private String password;
    private String firstname;
    private String lastname;

    private Usersrole usersrole;

    public UsersCommand() {
    }

    public UsersCommand(Integer userid) {
        this.userid = userid;
    }

    public UsersCommand(Integer userid, String username, String password, String firstname, String lastname) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

  
    public Usersrole getUsersrole() {
        return usersrole;
    }

    public void setUsersrole(Usersrole usersrole) {
        this.usersrole = usersrole;
    }

    
}

