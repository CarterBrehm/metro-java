/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab8b;
import java.io.*;

/**
 *
 * @author carter
 */

public class ReadCN
{
	public static void main(String[] args)
	{
		String aLine = "";
                File f = null;
                BufferedReader br = null;
                try {
                    f = new File("../BrehmLab8A/temp.txt");
                    br = new BufferedReader(new FileReader(f));
                    while(true)
                    {
                            aLine = br.readLine();
                            if(aLine == null)
                                 break;
                            System.out.println(aLine);
                    }
                }
                
                catch (FileNotFoundException e) {
                    System.err.println("Couldn't find the file! Error:");
                    System.err.println(e);
                }
                
                catch (IOException e) {
                    System.err.println("Couldn't read from the file! Error:");
                    System.err.println(e);
                }
                
                finally {
                    try {
                        br.close();
                    } catch (Exception ex) {
                        System.err.println("Couldn't close the file! Error:");
                        System.err.println(ex);
                    }
                }
	}   
}
