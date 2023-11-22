package Task11_01;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CreateXml {
public static void createXML(File file){
    // creating xml file
    try {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.newDocument();
        Element root = doc.createElement("address");
        doc.appendChild(root);

        // creating element 'city'
        Element city = doc.createElement("city");
        city.setTextContent("Kyiv");
        root.appendChild(city);
        city.setAttribute("size", "big");

        // street
        Element street = doc.createElement("street");
        street.setTextContent("Vyshgorodska");
        root.appendChild(street);

        // house
        Element house = doc.createElement("house");
        house.setTextContent("56");
        root.appendChild(house);

        // save
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult sr = new StreamResult(file);

        // Трансформуємо із джерела у файл
        t.transform(source, sr);
    }
    catch (Exception e){
        System.out.println(e);
    }
}
}
