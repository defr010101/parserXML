package again.model;

import java.util.List;

public class Root {
    private List<Element> elementList;

    public Root(List<Element> elementList) {
        this.elementList = elementList;
    }
    public Root() {
        this(null);
    }
    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }

    @Override
    public String toString() {
        return "Root{" +
                "elementList=" + elementList +
                '}';
    }
}
