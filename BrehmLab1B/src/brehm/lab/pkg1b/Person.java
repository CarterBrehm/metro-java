/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehm.lab.pkg1b;

/**
 *
 * @author crbrehm
 */
public class Person {
    
    public Person(String setFirstName, String setLastName, int setAge) {
        firstName = setFirstName;
        lastName = setLastName;
        age = setAge;
    }
    public String firstName;
    public String lastName;
    public int age;
    
    public String toString() {
        return firstName + " " + lastName + ": " + age;
    }
}
