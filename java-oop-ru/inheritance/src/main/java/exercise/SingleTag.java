package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public String name;
    public Map<String, String> attributes;

    public SingleTag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        String stringAttributes = attributes.keySet().stream().reduce("", (acc, curr) -> acc + " " + curr + "=\"" + attributes.get(curr) + "\"");
        return "<" + name + stringAttributes + '>';
    }
}
