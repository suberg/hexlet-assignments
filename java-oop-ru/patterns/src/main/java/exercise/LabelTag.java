package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    public String value;
    public TagInterface child;

    public LabelTag(String value, TagInterface child) {
        this.value = value;
        this.child = child;
    }

    @Override
    public String render() {
        return "<label>" + value + child.render() + "</label>";
    }
}
// END
