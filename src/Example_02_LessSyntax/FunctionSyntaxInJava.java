package Example_02_LessSyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionSyntaxInJava {
    public static void main(String[] args) throws Exception {
        List<Integer> primes = Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17, 19, 23);
        List<Integer> possiblePrimes = applyForEach(primes,
            new IntFunction() {
                public int evaluate(int n) {
                    return doubleAndMinusOne(n);
                }
            }
        );
        System.out.println("possiblePrimes = " + possiblePrimes);
    }

    private static int doubleAndMinusOne(int n) {
        return n * 2 - 1;
    }

    private static List<Integer> applyForEach(List<Integer> inputs, IntFunction function) {
        ArrayList<Integer> result = new ArrayList<Integer>(inputs.size());
        for (int input : inputs) {
            result.add(function.evaluate(input));
        }
        return result;
    }

    interface IntFunction {
        int evaluate(int parameter);
    }
}
