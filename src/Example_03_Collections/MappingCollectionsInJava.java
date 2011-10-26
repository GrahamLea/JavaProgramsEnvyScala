package Example_03_Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MappingCollectionsInJava {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<String> numberStatements = new ArrayList<String>();
        for (int number : numbers) {
            numberStatements.add(number + " is " + (number % 2 != 0 ? "odd" : "even"));
        }

        for (String s : numberStatements) {
            System.out.println(s);
        }
    }
}
