/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg1a;

import java.util.Scanner;

/**
 *
 * @author crbrehm
 */
public class Lab1A {
    
    public static boolean isNumber(String numberToTest) {
        try {
            double convertedNumber = Double.parseDouble(numberToTest);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // import the scanner library to read the console
        Scanner scanner = new Scanner(System.in);
        
        //set the initial value of the variables so that the loop will run at least once
        String firstNumber = "initialValue";
        String secondNumber = "initialValue";
        
        
        //import the values from the user, using the isNumber function for verification
        while (!isNumber(firstNumber)){
            System.out.println("Enter the first number:");
            firstNumber = scanner.nextLine();
        }
        while (!isNumber(secondNumber)) {
            System.out.println("Enter the second number:");
            secondNumber = scanner.nextLine();
        }
        
        //convert both strings to doubles, now that they have been verified as numbers
        Double firstDouble = Double.parseDouble(firstNumber);
        Double secondDouble = Double.parseDouble(secondNumber);
        
        // end the program with the math, printing each one as an equation using string concat
        System.out.println(firstDouble + " + " + secondDouble + " = " + (firstDouble + secondDouble));
        System.out.println(firstDouble + " - " + secondDouble + " = " + (firstDouble - secondDouble));
        System.out.println(firstDouble + " * " + secondDouble + " = " + (firstDouble * secondDouble));
        System.out.println(firstDouble + " / " + secondDouble + " = " + (firstDouble / secondDouble));
        
    }
    
}
