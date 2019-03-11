/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab2b;
import java.util.Scanner;
import java.text.NumberFormat;
/**
 *
 * @author crbrehm
 */
public class BrehmLab2B {

    /**
     * @param the command line arguments
     */
    //this function takes the total and divides it by the passed amount, using mod to set a new total so that it can be run sequentially
    public static double[] howManyFit(double amount, double total) {
        double quotient = total / amount;
        double newTotal = total % amount;
        double temp[] = new double[2];
        temp[0] = quotient;
        temp[1] = newTotal;
        return temp;
    }
    
    public static void main(String[] args) {
        //initialize the scanner and numberformat objects
        Scanner scanner = new Scanner(System.in);
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        //take data from the user
        System.out.println("Enter the price of the item:");
        System.out.print("$");
        double price = scanner.nextDouble();
        System.out.println("How much has the customer paid?");
        System.out.print("$");
        double paid = scanner.nextDouble();
        
        //calculate the change and format all the values
        double change = paid - price;
        
        //print the overall values
        System.out.println("Price: " + nf.format(price));
        System.out.println("Cash Offered: " + nf.format(paid));
        System.out.println("Change: " + nf.format(change));
        
        //create the array where these values will be stored
        int coins[] = new int[8];
        
        //run the function over and over again, filling our coins array and whittling down the change variable
        double tempFit[] = howManyFit(20, change);
        coins[0] = (int) tempFit[0];
        change = tempFit[1];
        
        tempFit = howManyFit(10, change);
        coins[1] = (int) tempFit[0];
        change = tempFit[1];
        
        tempFit = howManyFit(5, change);
        coins[2] = (int) tempFit[0];
        change = tempFit[1];
        
        tempFit = howManyFit(1, change);
        coins[3] = (int) tempFit[0];
        change = tempFit[1];
        
        tempFit = howManyFit(0.25, change);
        coins[4] = (int) tempFit[0];
        change = tempFit[1];
        
        tempFit = howManyFit(0.1, change);
        coins[5] = (int) tempFit[0];
        change = tempFit[1];
        
        tempFit = howManyFit(0.05, change);
        coins[6] = (int) tempFit[0];
        change = tempFit[1];
        
        tempFit = howManyFit(0.01, change);
        coins[7] = (int) tempFit[0];
        change = tempFit[1];
        
        //after all that, print everything
        System.out.println("Twenties: " + coins[0]);
        System.out.println("Tens: " + coins[1]);
        System.out.println("Fives: " + coins[2]);
        System.out.println("Ones: " + coins[3]);
        System.out.println("Quarters: " + coins[4]);
        System.out.println("Dimes: " + coins[5]);
        System.out.println("Nickels: " + coins[6]);
        System.out.println("Pennies: " + coins[7]);
    }
    
}
