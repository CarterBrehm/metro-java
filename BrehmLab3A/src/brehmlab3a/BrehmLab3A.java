/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab3a;

import java.util.Scanner;

/**
 *
 * @author crbrehm
 */
public class BrehmLab3A {

    public static double calculatePay(double passedPayrate, int passedHours) {
        if (passedHours < 40) {
            return (passedHours * passedPayrate);
        } else {
            return ((40 * passedPayrate) + ((passedHours - 40) * (1.5 * passedPayrate)));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = -1;
        double payrate = -1;
        double combinedPay = 0;
        double pay;
        
        while (true) {
            while (true) {
                System.out.println("How many hours has the employee worked this week?");
                try {
                    hours = Integer.parseInt(scanner.nextLine());
                    if (hours < 0) {
                        System.out.println("INVALID: Employee must have worked more than 0 hours.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("INVALID: Hours worked must be a whole number.");
                }

            }
            while (true) {
                System.out.println("What is the employee's payrate?");
                System.out.print("$");
                try {
                    payrate = Double.parseDouble(scanner.nextLine());
                    if (payrate < 7.25) {
                        System.out.println("INVALID: Payrate must be more than $7.25.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("INVALID: Payrate must be a number.");
                }
            }
            
            pay = calculatePay(payrate, hours);
            combinedPay += pay;
            System.out.println("The total pay for this employee is $" + pay + ".");
            System.out.println("Enter \"t\" to view the running total, or any other key to add another employee.");
            if ("t".equals(scanner.nextLine())) {
                break;
            } else {
                System.out.println();
                System.out.println();
            }
        }
        
        System.out.println("Total Pay Calculated: $" + combinedPay);
    }
}
