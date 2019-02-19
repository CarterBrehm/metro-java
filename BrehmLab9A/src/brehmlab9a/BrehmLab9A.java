/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab9a;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author carterbrehm
 */
public class BrehmLab9A {

    public static File pickFile() {
        FileDialog dialog = null;
        File toRead = null;
        try {
            dialog = new FileDialog((Frame) null, "Select File to Open");
            dialog.setMode(FileDialog.LOAD);
            dialog.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error opening the filepicker dialog!");
            System.err.println(e);
        }

        if (dialog.getFile() == null) {
            System.out.println("User cancelled file dialog.");
        } else {
            toRead = new File(dialog.getFile());
        }

        return toRead;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader breader = null;
        BufferedWriter bwriter = null;
        String aLine;

        while (true) {
            System.out.println("Would you like to read (r) or write (w) to a file?");
            String input = sc.nextLine();
            if (input.contains("r")) {
                File toRead = pickFile();
                if (toRead.canRead()) {
                    try {
                        System.out.println("Contents of File " + toRead + ":");
                        System.out.println();
                        breader = new BufferedReader(new FileReader(toRead));
                        while (true) {
                            aLine = breader.readLine();
                            if (aLine == null) {
                                break;
                            }
                            System.out.println(aLine);
                        }
                        System.out.println();
                        System.out.println("End of File");
                    } catch (Exception e) {
                        System.out.println("The file was marked readable, but an error occured during reading!");
                        System.err.println(e);
                    } finally {
                        try {
                            if (breader != null) {
                                breader.close();
                            }
                        } catch (IOException ioeÏ) {
                        }
                    }
                } else {
                    System.out.println("This file is unreadable.");
                }
            } else if (input.contains("w")) {
                System.out.print("Text to Write:");
                input = sc.nextLine();
                System.out.println("Please select the file to write to:");
                File toWrite = pickFile();
                if (toWrite.canWrite()) {
                    try {
                        bwriter = new BufferedWriter(new FileWriter(toWrite, true));
                        bwriter.write(input);
                        System.out.println("Write complete! Wrote: " + input);
                    } catch (Exception e) {
                        System.out.println("The file was marked writeable, but an error occured during writing!");
                        System.err.println(e);
                    } finally {
                        try {
                            if (bwriter != null) {
                                bwriter.close();
                            }
                        } catch (IOException ioe2) {
                        }
                    }
                } else {
                    System.out.println("The file is not writable.");
                }
            }

        }
    }
}
