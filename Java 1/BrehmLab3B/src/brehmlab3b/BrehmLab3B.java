/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab3b;

/**
 *
 * @author crbrehm
 */
public class BrehmLab3B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //using a constructor
        Timesheet ts1 = new Timesheet(1004986, 7.50, 45);
        System.out.println("Employee #" + ts1.getID() + " worked " + ts1.getHours() + " hours this week at $" + ts1.getPayrate() + "/hr.");
        System.out.println("They earned $" + ts1.getWeeklyPay() + ".");
        
        //using the get and set methods
        System.out.println();
        ts1.setID(999865);
        ts1.setPayrate(15.10);
        ts1.setHours(30);
        System.out.println("Employee #" + ts1.getID() + " worked " + ts1.getHours() + " hours this week at $" + ts1.getPayrate() + "/hr.");
        System.out.println("They earned $" + ts1.getWeeklyPay() + ".");
    }
    
}
