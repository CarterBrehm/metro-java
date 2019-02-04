/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab7a;
import java.util.ArrayList;

/**
 *
 * @author crbrehm
 */
public class Inventory {
    ArrayList<Product> products = new ArrayList<Product>();
    double value = 0;
    
    public int getCount() {
        return products.size();
    }
    
    public void setProduct(Product insertedProduct) {
        products.add(insertedProduct);
    }
    
    public Product getProduct(int index) {
        return products.get(index);
    }
    
    public double getTotalValue() {
        for (Product product : products) {
            value += (product.getNumberOnHand() * product.getPrice());
        }
        return value;
    }
    
    /* The main advantage of using an ArrayList over a 
    normal array is that you don't have to resize the 
    array, and it is more user-friendly to interact with
    the array. However, this can also be a downfall. For
    example, there appears to be no way to set OR add
    at an index of the array. Extra code will need to
    be written to cover for any errors that may occur
    when setting to an empty element of the array or
    attempting to add to a spot that is already filled.
    ArrayList may be more friendly, but a normal array
    will give you more barebones control over the 
    contents of the array. */
}