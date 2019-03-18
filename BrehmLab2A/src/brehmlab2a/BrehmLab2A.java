/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab2a;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author carter
 */
public class BrehmLab2A {

    public static void fillMap(Map hm) {
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

    public static void saveMap(Map hm) {
        try {
            File f = new File("phonebook.ser");
            try (ObjectOutputStream objectStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {
                objectStream.writeObject(hm);
            }
            System.out.println("Phonebook has been saved to phonebook.ser in the project directory.");
        } catch (IOException e) {
            System.err.println("Error! Couldn't save the hashmap to disk. Check permissions or available disk space.");
            System.err.println(e);
        }
    }

    public static HashMap readMap() {
        HashMap hm = null;
        try {
            File f = new File("phonebook.ser");
            ObjectInputStream objectStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
            hm = (HashMap) objectStream.readObject();
            objectStream.close();
            System.out.println("Phonebook has been read from phonebook.ser in the project directory.");
        } catch (IOException e) {
            System.err.println("Error! Couldn't save the hashmap to disk. Check permissions.");
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error! Couldn't find a class in the file!");
            System.err.println(e);
        }
        return hm;
    }

    public static void main(String[] args) {
        Map<String, String> phonebook = new HashMap<>();

        fillMap(phonebook);
        saveMap(phonebook);
        phonebook = readMap();

        for (String key : phonebook.keySet()) {
            String name = key;
            String number = phonebook.get(name);
            System.out.println(key + " : " + number);
        }

    }

}
