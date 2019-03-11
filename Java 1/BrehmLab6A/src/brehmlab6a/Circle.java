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
public class Circle extends Shape {
    
    double radius = 3;
    
    public Circle(String desc, double radius) {
        super(desc);
        this.radius = radius;
    }
    
    public double getArea() {
        double area = Math.PI * (radius * radius);
        return area;
    }
    
    public String toString() {
        String overview = this.getDesc() + ":\nRadius: " + this.radius + "\nArea: " + this.getArea();
        return overview;
    }
    
}
