package again.model;

public class Element {
    private String name;
    private int price;

    public Element(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public Element() {
        this("", 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Element{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
