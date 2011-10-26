package Example_01_TypeInference;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoTypeInferenceInJava {
    public static void main(String[] args) {
        BigInteger profit = new BigInteger("12345678.99");
        Map<String, Customer> customersById = new HashMap<String, Customer>();
        List<String> strings = Arrays.asList("one", "two", "three");
//        strings.add(profit); // doesn't compile: "cannot find method add(BigInteger)
    }

    private class Customer {
    }
}
