/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab7a;

/**
 *
 * @author carter
 */
public class BrehmLab7A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        
        Product product1 = new Product("Banana", 6, 8, 20.95);
        inventory.setProduct(product1);
        Product product2 = new Product("Apple", 6, 8, 20.95);
        inventory.setProduct(product2);
        Product product4 = new Product("Orange", 6, 8, 40.95);
        inventory.setProduct(product4);
        Product product5 = new Product("Mango", 6, 8, 40.95);
        inventory.setProduct(product5);
        Product product6 = new Product("Pineapple", 6, 8, 40.95);
        inventory.setProduct(product6);
        Product product7 = new Product("Cucumber", 6, 8, 40.95);
        inventory.setProduct(product7);
        Product product8 = new Product("Watermelon", 6, 8, 40.95);
        inventory.setProduct(product8);
        
        System.out.println("There are " + inventory.getCount() + " products stored in the array.");
        System.out.println("The total value on hand is $" + inventory.getTotalValue() + ".");
        for (int i = 0; i < inventory.getCount(); i++) {
            Product product = inventory.getProduct(i);
            System.out.println();
            System.out.println(product);
        }
    }
    
}
