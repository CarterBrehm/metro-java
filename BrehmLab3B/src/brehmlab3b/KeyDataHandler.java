/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab3b;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author carter
 */
public class KeyDataHandler extends DefaultHandler {

    private StringBuffer sb = new StringBuffer();
    private boolean readStatus;
    private boolean lineBreakStatus;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "TITLE":
                sb.append("\n\nTitle: ");
                readStatus = true;
                break;
            case "ARTIST":
                sb.append("\nArtist: ");
                readStatus = true;
                break;
            case "YEAR":
                sb.append("\nYear: ");
                readStatus = true;
                lineBreakStatus = true;
                break;
            default:
                break;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        readStatus = false;
        if (lineBreakStatus == true) {
            sb.append("\n");
            lineBreakStatus = false;
        }
    }

    public void characters(char buf[], int offset, int len) throws SAXException {
        if (readStatus) {
            sb.append(buf, offset, len);
        }
    }

    public void endDocument() throws SAXException {
        System.out.println(sb);
    }

}
