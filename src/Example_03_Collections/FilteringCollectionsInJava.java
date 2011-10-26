package Example_03_Collections;

import java.util.*;

public class FilteringCollectionsInJava {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> oddNumbers = new ArrayList<Integer>();
        for (int number : numbers) {
            if (number % 2 != 0)
                oddNumbers.add(number);
        }

        System.out.println("oddNumbers = " + oddNumbers);
    }
}
