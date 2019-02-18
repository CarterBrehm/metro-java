/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab9a;
import java.awt.*;

/**
 *
 * @author carterbrehm
 */
public class BrehmLab9A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String file = dialog.getFile();
        System.out.println(file + " chosen.");
    }
    
}
