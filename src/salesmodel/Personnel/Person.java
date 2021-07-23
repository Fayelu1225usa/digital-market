/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.Personnel;

/**
 *
 * @author kal bugrara
 */
public class Person {

    String id;
    String name;

    public Person(String id) {

        this.id = id;
        this.name = id;
    }

    public String getPersonId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isMatch(String id) {

        return (getPersonId().equals(id));
    }

}
