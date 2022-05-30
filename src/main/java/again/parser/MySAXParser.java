package again.parser;

import again.model.Root;

import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class MySAXParser {
    public Root parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        MySAXHandler handler = new MySAXHandler();
        SAXParser parser;
        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
        File file = new File(fileName);
        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println("SAX error: " + e.toString());
        } catch (IOException e) {
            System.out.println("IO error: " + e.toString());
        }

        return handler.getRoot();
    }
}
