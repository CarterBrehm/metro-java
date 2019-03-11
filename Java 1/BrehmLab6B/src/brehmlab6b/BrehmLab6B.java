/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab6b;

/**
 *
 * @author crbrehm
 */
public class BrehmLab6B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("SHAPE ARRAY:");
        Shape shapes[] = new Shape[3];
        shapes[0] = new Circle("Circle", 7);
        shapes[1] = new RightTriangle("Right Triangle", 8, 3);
        shapes[2] = new Rectangle("Rectangle", 4, 9);
        
        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println();
        }
        
        System.out.println("OBJECT ARRAY:");
        Object objects[] = new Object[3];
        objects[0] = new Circle("Circle", 2);
        objects[1] = new RightTriangle("Right Triangle", 2, 7);
        objects[2] = new Rectangle("Rectangle", 11, 3);
        
        for (Object object : objects) {
            System.out.println(object);
            System.out.println();
        }
    }
    
}
