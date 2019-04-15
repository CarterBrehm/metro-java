/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmmidterm;

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
            contents = "Error! Couldn't find the file!\n" + e;
        } catch (IOException e) {
            contents = "Error! Couldn't read from the file!\n" + e;
        }

        return contents;
    }

    public static String write(String text, String filepath) {
        String contents = "";
        BufferedWriter bw = null;
        File f = new File("test.txt");
        try {
            f.createNewFile();

            bw = new BufferedWriter(new FileWriter(f));
            bw.write(text);

        } catch (IOException e) {
            contents = "Error! Couldn't write to the file!\n" + e;
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    contents = "Error! Couldn't close the file!\n" + e;
                }
            }
        }
        return contents;
    }
}
