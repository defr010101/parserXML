package again.parser;

import again.model.Element;
import again.model.Root;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MySAXHandler extends DefaultHandler {
    private Root root;

    private String currentName;
    private boolean isElement;

    private List<Element> elementList;
    private String name;
    private int price;

    public Root getRoot() {
        return root;
    }

    @Override
    public void startDocument() throws SAXException {
        elementList = new ArrayList<>();
        root = new Root();
        isElement = false;
        name = "";
        price = 0;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentName = qName;
        if (currentName.equals("element")) {
            isElement = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentName == null) {
            return;
        }

        if (isElement) {
            if (currentName.equals("name")) {
                name = new String(ch, start, length);
            } else if (currentName.equals("price")) {
                price = Integer.parseInt(new String(ch, start, length));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("element")) {
            isElement = false;

            Element element = new Element(name, price);
            elementList.add(element);
        }
        currentName = null;
    }

    @Override
    public void endDocument() throws SAXException {
        root.setElementList(elementList);
    }
}
