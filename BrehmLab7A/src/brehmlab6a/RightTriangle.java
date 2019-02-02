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
public class RightTriangle extends Shape {
    
    double base = 3;
    double height = 4;
    
    public RightTriangle(String desc) {
        super(desc);
    }
    
    public double getArea() {
        double area = (height * base) / 2;
        return area;
    }
    
    public String toString() {
        String overview = this.getDesc() + ":\nBase: " + this.base + "\nHeight: " + this.height + "\nArea: " + this.getArea();
        return overview;
    }    
}
