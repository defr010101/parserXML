package first;

import first.model.People;
import first.model.Root;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaxParserHadler extends DefaultHandler {
    private Root root = new Root();
    private List<People> peopleList = new ArrayList<>();

    private String currentTagName;
    private boolean isPeople = false;
    private boolean isElement = false;

    private String name;
    private int age;

    public Root getRoot() {
        return root;
    }

    @Override
    public void endDocument() throws SAXException {
        root.setPeople(peopleList );
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTagName = qName;
        if (currentTagName.equals("people")) {
            isPeople = true;
        } else if (currentTagName.equals("element")) {
            isElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("people")) {
            isPeople = false;
        } else if (qName.equals("element")) {
            isElement = false;

            People people = new People(name, age);
            peopleList.add(people);
        }

        currentTagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentTagName == null) {
            return;
        }

        if (!isPeople && currentTagName.equals("name")) {
            root.setName(new String(ch, start, length));
        } else if (isPeople && isElement) {
            if (currentTagName.equals("name")) {
                name = new String(ch, start, length);
            } else if (currentTagName.equals("age")) {
                age = Integer.parseInt(new String(ch, start, length));
            }
        }
    }
}
