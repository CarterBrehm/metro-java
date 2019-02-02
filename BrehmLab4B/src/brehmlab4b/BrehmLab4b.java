/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab4b;

/**
 *
 * @author crbrehm
 */
public class BrehmLab4b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person people[] = new Person[3];
        people[0] = new Person("Carter", "Brehm", 16);
        people[1] = new Person("Collin", "Keating", 16);
        people[2] = new Person("Randall", "Mowen", 16);
        
        for (Person person : people) {
            System.out.println(person);
        }
    }
    
}
