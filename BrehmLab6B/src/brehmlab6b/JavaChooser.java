/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab6b;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author crbrehm
 */
public class JavaChooser extends JFrame {

    private JFileChooser jOpen = null;
    private JFileChooser jSave = null;

    public File showOpenDialog() {
        jOpen = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Text Files", "txt");
        jOpen.setFileFilter(filter);
        int returnVal = jOpen.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return jOpen.getSelectedFile();
        }
        return null;
    }

    public File showSaveDialog() {
        jSave = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Text Files", "txt");
        jSave.setFileFilter(filter);
        int returnVal = jSave.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return jSave.getSelectedFile();
        }
        return null;
    }
}
