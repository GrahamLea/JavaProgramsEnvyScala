package Example_03_Collections;

import java.util.Arrays;
import java.util.List;

public class SummingCollectionsOfNumbersInJava {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        System.out.println("total = " + total);
    }
}
