/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab6a;

/**
 *
 * @author crbrehm
 */
public class BrehmLab6A {

    public static void main(String[] args) {
        Circle c = new Circle("Circle");
        RightTriangle t = new RightTriangle("Right Triangle");
        Rectangle r = new Rectangle("Rectangle");
        
        System.out.println(c);
        System.out.println();
        System.out.println(t);
        System.out.println();
        System.out.println(r);
    }
    
}
