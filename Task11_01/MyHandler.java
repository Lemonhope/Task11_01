package Task11_01;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler extends DefaultHandler {

    boolean bAddress = false;
    boolean bCity = false;
    boolean bStreet = false;
    boolean bHouse = false;
    String size;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("address")) {
            bAddress=true;

        } else if (qName.equalsIgnoreCase("city")) {
            size=attributes.getValue("size");

            // set boolean values for fields, will be used in setting Address variables
            bCity = true;
        } else if (qName.equalsIgnoreCase("street")) {
            bStreet = true;
        } else if (qName.equalsIgnoreCase("house")) {
            bHouse = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bAddress) {
            //bAddress = false;
        }else if (bCity) {
            bCity = false;
        } else if (bStreet) {
            bStreet = false;
        } else if (bHouse) {
            bHouse = false;
        }

    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if(bCity){
            System.out.println("Address:");
            System.out.println("City: size = "+ size + " " +new String(ch, start, length));
            bCity=false;
        } else if (bStreet) {
            System.out.println("Street: "+new String(ch, start, length));
        }else if (bHouse) {
            System.out.println("House: "+new String(ch, start, length));
        }
    }
}
