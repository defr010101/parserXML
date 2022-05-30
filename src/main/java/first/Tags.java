package first;

public enum Tags {
    TAG_MAIN_NAME("name"),
    TAG_PEOPLE("people"),
    TAG_ELEMENT("element"),
    TAG_NAME("name"),
    TAG_AGE("age");

    private final String name;

    Tags(String name) {
        this.name = name;
    }
}
