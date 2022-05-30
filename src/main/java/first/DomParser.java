package first;

import first.model.People;
import first.model.Root;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class DomParser {
    public Root parse(String fileName) {
        Root root = new Root();

        Document doc;

        String nodeName = "";
        Node nodePeople = null;

        try {
            doc = buildDocument(fileName);
        } catch (Exception ex) {
            System.out.println("Parsing file error: " + ex.toString());
            return null;
        }

        Node rootNode = doc.getFirstChild();
        NodeList rootChilds = rootNode.getChildNodes();

        for (int i = 0; i < rootChilds.getLength(); i++) {
            if (rootChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            switch(rootChilds.item(i).getNodeName()) {
                case "name": {
                    nodeName = rootChilds.item(i).getTextContent();
                    break;
                }
                case "people": {
                    nodePeople = rootChilds.item(i);
                    break;
                }
            }
        }

        List<People> listOfPeoples = parsePeopleList(nodePeople);

        root.setName(nodeName);
        root.setPeople(listOfPeoples);

        return root;
    }

    public Document buildDocument(String fileName) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder().parse(fileName);
    }

    public List<People> parsePeopleList(Node peopleNode) {
        List<People> peopleList = new ArrayList<>();
        NodeList peopleChilds = peopleNode.getChildNodes();

        for (int i = 0; i < peopleChilds.getLength(); i++) {
            if (peopleChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            People people = parsePeople(peopleChilds.item(i));
            peopleList.add(people);
        }

        return peopleList;
    }

    public People parsePeople(Node elementNode) {
        NodeList elementChilds = elementNode.getChildNodes();
        People people = new People();

        for (int j = 0; j < elementChilds.getLength(); j++) {
            if (elementChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            switch (elementChilds.item(j).getNodeName()) {
                case "name": {
                    people.setName(elementChilds.item(j).getTextContent());
                    break;
                }
                case "age": {
                    people.setAge(Integer.parseInt(elementChilds.item(j).getTextContent()));
                    break;
                }
            }
        }
        return people;
    }
}
