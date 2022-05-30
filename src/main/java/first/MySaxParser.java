package first;

import first.model.Root;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class MySaxParser {

    public Root parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHadler handler = new SaxParserHadler();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (Exception ex) {
            System.out.println("Open SAX parser error: " + ex.toString());
            return null;
        }

        File file = new File(fileName);
        try {
            parser.parse(file, handler);
        } catch (SAXException ex) {
            System.out.println("SAX parsing error: " + ex.toString());
            return null;
        } catch (IOException ex) {
            System.out.println("IO parsing error: " + ex.toString());
            return null;
        }

        return handler.getRoot();
    }
}
