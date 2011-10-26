package Example_02_LessSyntax;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;

public class ProceduralSyntaxInJava {
    public static void main(String[] args) {
        final BigDecimal principle = new BigDecimal("1000000");
        final BigDecimal interestRate = new BigDecimal("0.065");
        final int depositTerm = 10;
        final BigDecimal interestEarned =
            principle.multiply(interestRate.add(ONE).pow(depositTerm)).subtract(principle).setScale(2, ROUND_HALF_UP);
        System.out.println("interestEarned = " + interestEarned);
    }
}
