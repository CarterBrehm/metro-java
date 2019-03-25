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
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("cd_catalog.xml");

            NodeList nodelist = document.getElementsByTagName("CD");
            int num = nodelist.getLength();

            for (int i = 0; i < num; i++) {
                Node cd = nodelist.item(i);
                NodeList childNodes = cd.getChildNodes();
                System.out.println(childNodes.item(1).getTextContent() + childNodes.item(2).getTextContent() + childNodes.item(6).getTextContent());
            }

        } catch (ParserConfigurationException e) {
            System.err.print(e);
        } catch (SAXException e) {
            System.err.print(e);
        } catch (IOException e) {
            System.err.print(e);
        }

    }

}
