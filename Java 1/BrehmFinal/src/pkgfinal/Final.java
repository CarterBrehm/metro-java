/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author carterbrehm
 */
public class Final {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        ArrayList<Country> countries = new ArrayList<Country>();
        Scanner sc = new Scanner(System.in);
        String inputName;
        String lookupName;
        int inputPopulation;
        String shouldContinue;
        boolean found = false;
        
        while (true) {
            System.out.print("Enter a country name: ");
            inputName = sc.nextLine();
            
            System.out.print("Enter the population of " + inputName + ": ");
            inputPopulation = sc.nextInt();
            
            countries.add(new Country(inputName, inputPopulation));
            
            sc.nextLine();
            
            System.out.print("Would you like to add another country? (y/n) ");
            shouldContinue = sc.nextLine();
            if (shouldContinue.contains("n")) {
                break;
            }   
        }
        
        while (true) {
            System.out.print("Enter a country name to lookup: ");
            lookupName = sc.nextLine();
            for (Country country : countries) {
                if (country.getName().toLowerCase().contains(lookupName.toLowerCase())) {
                    found = true;
                    System.out.println(country.getName() + " has a population of " + country.getPopulation() + " people.");
                    break;
                }
            }
            if (!found) {
                System.out.println("No matches found.");
            }
            System.out.print("Would you like to lookup another country? (y/n) ");
            shouldContinue = sc.nextLine();
            if (shouldContinue.contains("n")) {
                break;
            }  
        }
    }
    
}
