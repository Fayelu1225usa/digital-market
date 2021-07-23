/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.Personnel;

import userbusiness.Account;

/**
 *
 * @author kal bugrara
 */
public class EmployeeProfile {

    Person person;
    Account credentials;

    public EmployeeProfile(Person p) {
        person = p;
        this.credentials = new Account(person);
    }
    
    public String getID(){
        return this.person.getPersonId();
    }
    
    public void setName(String name){
        this.person.setName(name);
    }
    
    public String getName(){
        return this.person.name;
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public void setCredentials(Account credentials) {
        this.credentials = credentials;
    }

    public Account getCredentials() {
        return this.credentials;
    }

}
