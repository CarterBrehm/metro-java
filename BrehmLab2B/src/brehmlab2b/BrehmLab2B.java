/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab2b;

import java.util.Scanner;

/**
 *
 * @author carter
 */
public class BrehmLab2B {

    /**
     * @param args the command line arguments
     */
    public static void menu(Phonebook phonebook) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------");
            System.out.println("Choose an option:");
            System.out.println("[1] Add entries to the phonebook");
            System.out.println("[2] Lookup entries from the phonebook");
            System.out.println("[3] Save the phonebook to disk and exit");

            String input = sc.nextLine();
            if (input.contains("1")) {
                phonebook.fillMap();
            } else if (input.contains("2")) {
                phonebook.lookupMap();
            } else if (input.contains("3")) {
                phonebook.saveMap();
                break;
            } else {
                
            }
        }

    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        menu(phonebook);
    }

}
