package Example_07_PatternMatching;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class DecisionBasedOnListContentsWithJava {

    public static class Name {
        private final List<String> names;
        public Name(List<String> names) { this.names = names; }
        public String toString() { return "Name: " + names; }
    }

    public static class Languages {
        private final List<String> languages;
        public Languages(List<String> languages) { this.languages = languages; }
        public String toString() { return "Languages: " + languages; }
    }

    private static Object interpret(List<String> strings) {
        if (strings.size() == 0)
            return null;

        if ("Name:".equals(strings.get(0)))
            return new Name(strings.subList(1, strings.size()));

        if ("Languages:".equals(strings.get(0)))
            return new Languages(strings.subList(1, strings.size()));

        throw new IllegalArgumentException("Unknown label: " + strings.get(0));
    }

    public static void main(String[] args) {
        System.out.println(interpret(asList("Name:", "Graham", "Lea")));
        System.out.println(interpret(asList("Languages:", "Java", "Scala", "Javascript", "HTML", "SQL", "Shell", "etc.")));
        System.out.println(interpret(Arrays.<String>asList()));
    }
}
