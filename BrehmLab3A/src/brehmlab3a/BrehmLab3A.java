/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab3a;

import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;
import javax.xml.parsers.*;
import java.text.*;

/**
 *
 * @author carter
 */
public class BrehmLab3A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            // create a document object and parse it into a NodeList
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("cd_catalog.xml");
            
            // select all of the CD top-level elements
            NodeList nodelist = document.getElementsByTagName("CD");
            int num = nodelist.getLength();
            
            // loop through each of the CD elements that were found and print details about them
            for (int i = 0; i < num; i++) {
                
                // cast it to an element so that we can do getElementsByTagName later
                Element cd = (Element) nodelist.item(i);
                
                // print the descriptor, then get the first element that comes up when we search for a tag and print the text content of the element
                System.out.println("Title: " + cd.getElementsByTagName("TITLE").item(0).getTextContent());
                System.out.println("Artist: " + cd.getElementsByTagName("ARTIST").item(0).getTextContent());
                System.out.println("Year: " + cd.getElementsByTagName("YEAR").item(0).getTextContent());
                System.out.println();
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.err.print(e);
        }

    }

}
