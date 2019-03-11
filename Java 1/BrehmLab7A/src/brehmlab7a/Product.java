/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab7a;

/**
 *
 * @author crbrehm
 */
public class Product {
    private String productName;
    private int numberOnHand;
    private int numberOnOrder;
    private double price;
    
    public Product(String productName, int numberOnHand, int numberOnOrder, double price) {
        setProductName(productName);
        setNumberOnHand(numberOnHand);
        setNumberOnOrder(numberOnOrder);
        setPrice(price);
    }
    
    public Product() {
        //nothing
    }
    
    public String toString() {
        String overview = "Product: " + productName + "\nNumber On Hand: " + numberOnHand + "\nNumber To Order: " + numberOnOrder + "\nPrice: $" + price;
        return overview;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumberOnHand() {
        return numberOnHand;
    }

    public void setNumberOnHand(int numberOnHand) {
        if (numberOnHand < 0) {numberOnHand = 0;}
        this.numberOnHand = numberOnHand;
    }

    public int getNumberOnOrder() {
        return numberOnOrder;
    }

    public void setNumberOnOrder(int numberOnOrder) {
        if (numberOnOrder < 0) {numberOnOrder = 0;}
        this.numberOnOrder = numberOnOrder;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {price = 0;}
        this.price = price;
    }
}