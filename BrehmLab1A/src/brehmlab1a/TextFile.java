/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab1a;

import java.io.*;

/**
 *
 * @author carter
 */
public class TextFile {

    public static String read(String filepath) {
        String contents = "";
        try {
            File file = new File(filepath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            System.out.println();
            while (true) {
                String readLine = br.readLine();
                if (readLine == null) {
                    break;
                }
                contents += readLine;
                contents += "\n";
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error! Couldn't find the file!\n" + e);
        } catch (IOException e) {
            System.err.println("Error! Couldn't read from the file!\n" + e);
        }

        return contents;
    }

    public static void write(String text, String filepath) {
        BufferedWriter bw = null;
        File f = new File("test.txt");
        try {
            f.createNewFile();

            bw = new BufferedWriter(new FileWriter(f));
            bw.write(text);

        } catch (IOException e) {
            System.err.println("Error! Couldn't write to the file!\n" + e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.err.println("Error! Couldn't close the file!\n" + e);
                }
            }
        }
    }

    public static void append(String text, String filepath) {
        BufferedWriter bw = null;
        File f = new File("test.txt");
        try {
            f.createNewFile();

            bw = new BufferedWriter(new FileWriter(f, true));
            bw.append(text);

        } catch (IOException e) {
            System.err.println("Error! Couldn't append to the file!\n" + e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.err.println("Error! Couldn't close the file!\n" + e);
                }
            }
        }
    }
}
