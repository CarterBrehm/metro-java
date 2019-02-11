/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab8a;

import java.io.*;

public class WriteCN
{
	public static void main(String[] args)
	{
		BufferedWriter bw = null;
		File f = new File("temp.txt");
		String[] textArray =  {"Four", "Score", "And", "Seven", "Years", "Ago"};
                try {
                    f.createNewFile();

                    bw = new BufferedWriter(new FileWriter(f));

                    for(int i = 0; i < textArray.length; i++){
                            bw.write(textArray[i]);
                            bw.newLine();
                    }
                }
                catch (IOException e) {
                    System.out.println("Couldn't write to the file! Error:");
                    System.out.println(e);
                }
                finally {
                    if(bw != null) try {
                        bw.close();
                    } catch (IOException ex) {
                        System.out.println("Couldn't close the file! Error:");
                        System.out.println(ex);
                    }
                }
	}
}

