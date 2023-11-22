// Створіть клас, використовуючи SAXParser, де опишіть ієрархію XML файлу.
// Необхідно, щоб проект створював XML-файл і будував дерево - місто, назва вулиці, будинок.
// У місті використовуйте атрибут : наприклад, Кyiv.
package Task11_01;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file=new File("xmlData.xml");
        CreateXml.createXML(file);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();

            saxParser.parse(file, handler);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
