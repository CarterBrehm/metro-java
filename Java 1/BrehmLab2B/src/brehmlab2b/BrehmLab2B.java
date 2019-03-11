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
public class BrehmLab2B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //using the constructor
        Person person = new Person("Tim", "Cook", 58);
        System.out.println(person.toString());
        
        //using the get and set methods
        person.setFirstName("Carter");
        person.setLastName("Brehm");
        person.setAge(16);
        System.out.println(person.toString());
    }
    
}
