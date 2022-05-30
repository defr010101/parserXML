package again;

import again.model.Root;
import again.parser.MySAXParser;

public class Main {
    public static void main(String[] args) {
        MySAXParser parser = new MySAXParser();
        Root root = parser.parse("data2.xml");

        System.out.println(root);
    }
}
