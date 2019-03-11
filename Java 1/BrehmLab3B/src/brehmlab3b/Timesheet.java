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
public final class Timesheet {
    
    //constructor
    public Timesheet(int passedId, double passedPayrate, int passedHours) {
        setID(passedId);
        setPayrate(passedPayrate);
        setHours(passedHours);
    }
    
    private int id;
    private double payrate;
    private int hours;
    
    //setting methods
    public void setID(int passed) {
        id = passed;
    }
    
    public void setPayrate(double passed) {
        if (passed < 7.25) {
            passed = 7.25;
        }
        payrate = passed;
    }
    
    public void setHours(int passed) {
        if (passed < 0) {
            passed = 0;
        }
        hours = passed;
    }
    
    //getting methods
    public int getID() {
        return id;
    }
    
    public double getPayrate() {
        return payrate;
    }
        
    public int getHours() {
        return hours;
    }
    
    public double getWeeklyPay() {
        if (hours < 40) {
            return (hours * payrate);
        } else {
            return ((40 * payrate) + ((hours - 40) * (1.5 * payrate)));
        }
    }
}
