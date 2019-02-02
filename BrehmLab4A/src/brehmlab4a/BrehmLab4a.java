/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab4a;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author crbrehm
 */
public class BrehmLab4a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int count = 0;
        String[] values = {"Ace", "King", "Queen", "Jack", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two"};
        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
        String[] cards = new String[52];
        
        for (String value : values) {
            for (String suit : suits) {
                cards[count] = value + " of " + suit;
                count++;
            }
        }
        
        Collections.shuffle(Arrays.asList(cards));
        
        for (int i = 0; i < 5; i++) {
            System.out.println(cards[i]);
        }
    }
    
}
