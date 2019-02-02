/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab2b;

/**
 *
 * @author crbrehm
 */
public class Person {
   
    //constructor
    public Person(String passedFirstName, String passedLastName, int passedAge) {
        setFirstName(passedFirstName);
        setLastName(passedLastName);
        setAge(passedAge);
    }
    
    private String firstName;
    private String lastName;
    private int age;
    
    
    public String toString() {
        return firstName + " " + lastName + ": " + age;
    }
    
    //setting methods
    public void setFirstName(String passed) {
        firstName = passed;
    }
    
    public void setLastName(String passed) {
        lastName = passed;
    }
    
    public void setAge(int passed) {
        if (passed < 0) {
            passed = 0;
        }
        age = passed;
    }
    
    //getting methods
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
        
    public int getAge() {
        return age;
    }
        
}
