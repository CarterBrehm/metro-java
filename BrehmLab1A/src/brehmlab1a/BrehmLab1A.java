/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab1a;
import java.util.Scanner;

/**
 *
 * @author carter
 */
public class BrehmLab1A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("| READING FILE |");
        System.out.println(TextFile.read("test.txt"));
        System.out.println("| END READ |");
        
        System.out.println("| WRITING TO FILE |");
        System.out.println();
        System.out.print("Please enter some text to write: ");
        TextFile.write(scanner.nextLine(), "test.txt");
        System.out.println();
        System.out.println("| END WRITE |");
        
        System.out.println("| APPENDING TO FILE| ");
        System.out.println();
        System.out.print("Please enter some text to append: ");
        TextFile.append(scanner.nextLine(), "test.txt");
        System.out.println();
        System.out.println("| END APPEND |");
    }
    
}
