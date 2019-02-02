/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab5b;

/**
 *
 * @author crbrehm
 */
public class Inventory {
    private Product[] products = new Product[100];
    int iterator = 0;
    
    public int getCount() {
        int counter = 0;
        for (Product product : products) {
            if (product != null) {
                counter++;
            }
        }
        return counter;
    }
    
    public void setProduct(Product insertedProduct) {
        products[this.getCount()] = insertedProduct;
    }
    
    public Product getProduct(int index) {
        return products[index];
    }
}
