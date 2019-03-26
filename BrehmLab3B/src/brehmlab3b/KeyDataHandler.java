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
    
    // this is the function thats called when a new element is discovered...
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // ... so this is where we need to add any custom formatting to output to the logs rather than just throwing data out there
        switch (qName) {
            // if the element we're reading is a TITLE...
            case "TITLE":
                // ...append a descriptor to the StringBuffer...
                sb.append("\n\nTitle: ");
                // ...tell the characters() function to read the next element because we care about the content inside it...
                readStatus = true;
                // ...then break so that the parser can read the characters 
                break;
            case "ARTIST":
                sb.append("\nArtist: ");
                readStatus = true;
                break;
            case "YEAR":
                sb.append("\nYear: ");
                readStatus = true;
                // this tells the endElement() function to add a line break after the next element, because the YEAR is the last thing we want printed
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
