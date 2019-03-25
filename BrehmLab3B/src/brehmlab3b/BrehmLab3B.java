package brehmlab3b;

import java.io.*;
import org.xml.sax.*;
import javax.xml.parsers.*;

public class BrehmLab3B {

    public static void main(String[] args) {
        try {
            KeyDataHandler handler = new KeyDataHandler();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            System.out.println("Beginning read...");
            saxParser.parse("cd_catalog.xml", handler);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.err.println(e);
        }
    }
}
