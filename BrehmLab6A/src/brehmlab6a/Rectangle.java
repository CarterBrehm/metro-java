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
public class Rectangle extends Shape {
    
    double width = 3;
    double height = 4;
    
    public Rectangle(String desc, double width, double height) {
        super(desc);
        this.width = width;
        this.height = height;
    }
    
    public double getArea() {
        double area = width * height;
        return area;
    }
    
    public String toString() {
        String overview = this.getDesc() + ":\nWidth " + this.width + "\nHeight: " + this.height + "\nArea: " + this.getArea();
        return overview;
    }  
    
}
