package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homeList, int n) {
        return homeList.stream().sorted(Comparator.comparing(Home::getArea)).limit(n).map(Home::toString).collect(Collectors.toList());
    }
}
// END
