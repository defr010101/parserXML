package first;

import first.model.Root;

public class Main {
    public static void main(String[] args) {
        // first.DomParser parser = new first.DomParser();
        MySaxParser parser = new MySaxParser();
        Root root = parser.parse("data.xml");

        System.out.println(root.toString());
    }
}
