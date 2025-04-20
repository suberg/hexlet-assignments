package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    public String name;
    public Map<String, String> attributes;
    public String body;
    public List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        this.name = name;
        this.attributes = attributes;
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        String stringAttributes = attributes.keySet().stream().reduce("", (acc, curr) -> acc + " " + curr + "=\"" + attributes.get(curr) + "\"");
        String stringChildren = children.stream().map(Tag::toString).collect(Collectors.joining());
        return "<" + name + stringAttributes + ">" + body + stringChildren + "</" + name + ">";
    }
}
// END
