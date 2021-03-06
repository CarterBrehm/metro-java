/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab2b;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author carter
 */
public class Phonebook {

    private Map<String, String> hm = new HashMap<>();

    public Phonebook() {
        hm = readMap();
    }

    public void lookupMap() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a name to perform a lookup, or type \"exit\" to quit.");
            System.out.print("Name: ");
            String input = sc.nextLine();
            if (input.contains("exit")) {
                break;
            } else {
                if (hm.containsKey(input)) {
                    System.out.println(input + "'s phone number is " + hm.get(input) + ".");
                } else {
                    System.out.println("Phone number not found for " + input + ".");
                }
            }
            System.out.println();
        }
    }

    public void fillMap() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a name (or type exit to stop): ");
            String name = sc.nextLine();
            if (!name.equals("exit")) {
                System.out.print("Enter a phone number: ");
                String number = sc.nextLine();
                hm.put(name, number);
            } else {
                break;
            }

        }
    }

    public void saveMap() {
        File f = new File("phonebook.ser");
        ObjectOutputStream objectStream = null;
        try {
            objectStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
            objectStream.writeObject(hm);
            System.out.println("Phonebook has been saved to phonebook.ser in the project directory.");
        } catch (IOException e) {
            System.err.println("Error! Couldn't save the hashmap to disk. Check permissions or available disk space.");
            System.err.println(e);
        } finally {
            try {
                objectStream.close();
            } catch (IOException e) {
                System.err.println("Error! Couldn't close the file!");
                System.err.println(e);
            }
        }
    }

    public HashMap readMap() {
        HashMap hm = null;
        File f = new File("phonebook.ser");
        ObjectInputStream objectStream = null;
        try {
            objectStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
            hm = (HashMap) objectStream.readObject();
            System.out.println("Phonebook has been read from phonebook.ser in the project directory.");
        } catch (IOException e) {
            System.err.println("Error! Couldn't save the hashmap to disk. Check permissions.");
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error! Couldn't find a class in the file!");
            System.err.println(e);
        } finally {
            try {
                objectStream.close();
            } catch (IOException e) {
                System.err.println("Error! Couldn't close the file!");
                System.err.println(e);
            }
        }
        return hm;
    }
}
