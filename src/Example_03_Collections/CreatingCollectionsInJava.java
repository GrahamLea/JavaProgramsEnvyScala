package Example_03_Collections;

import java.util.*;

public class CreatingCollectionsInJava {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        // Possible by creating your own static methods:
        // map(entry("One", 1), entry("Two", 2), entry("Three", 3));
    }
}
