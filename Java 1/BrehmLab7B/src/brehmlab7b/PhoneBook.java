/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab7b;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author carter
 */
public class PhoneBook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("Lanky Larry", "982-9489");
        phonebook.put("Bulky Brian", "094-2098");
        phonebook.put("Round Ryan", "124-0923");
        Scanner sc = new Scanner(System.in);
        String input;
        
        while (true) {
            System.out.println("Enter a name to perform a lookup, or type \"exit\" to quit.");
            System.out.print("Name: ");
            input = sc.nextLine();
            if (input.contains("exit")) {
                break;
            } else {
                if(phonebook.containsKey(input)) {
                    System.out.println(input + "'s phone number is " + phonebook.get(input) + ".");
                } else {
                    System.out.println("Phone number not found for " + input + ".");
                }
            }
            System.out.println();
        }
    }
    
}
