package Example_03_Collections;

import java.util.Arrays;
import java.util.List;

public class SummarisingCollectionsInJava {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);
        String output = "";
        for (int number : numbers) {
            output += (number % 2 == 0) ? "Even " : "Odd ";
        }
        System.out.println(output);
    }
}
