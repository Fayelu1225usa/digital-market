/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.CustomerManagement;

import java.util.ArrayList;

import salesmodel.Personnel.CustomerAccount;
import salesmodel.Personnel.Person;
import userbusiness.Account;

/**
 *
 * @author kal bugrara
 */
public class CustomerProfile {

    Person person;
    String name;
    ArrayList<String> characteristics;
    CustomerAccount account;
    Account credentials;

    public CustomerProfile(Person p) {

        person = p;
        name = p.getPersonId();
        this.characteristics = new ArrayList<String>();
        this.account = new CustomerAccount(this);
        this.credentials = new Account(person);

    }

    public void setName(String name) {
        this.name = name;
        this.person.setName(name);
    }

    public void addCharacter(String c) {
        this.characteristics.add(c);
    }

    public CustomerAccount getAccount() {
        return this.account;
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

    public String getName() {
        return this.name;
    }
    
    public String getID() {
        return this.person.getPersonId();
    }
    
    public ArrayList<String> getcharacters(){
        return this.characteristics;
    }
    
    public void setCharacters(ArrayList<String> chars){
        this.characteristics.clear();
        this.characteristics.addAll(chars);
    }
}
