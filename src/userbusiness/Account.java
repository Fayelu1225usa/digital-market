/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userbusiness;

import java.util.Date;

import salesmodel.Personnel.Person;

/**
 *
 * @author fayelu
 */
public class Account {

    private String User;
    private Integer Password;
    private String Role;
    private Date login;
    private Person person;

    public Account(Person p) {
        this.login = new Date();
        this.person = p;
        this.Role = null;
        this.Password = null;
        this.User = null;
    }

    public Person getPerson() {
        return this.person;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public int getPassword() {
        return Password.intValue();
    }

    public void setPassword(int Password) {
        this.Password = Password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public Date getLogin() {
        return login;
    }

}
