package Example_07_PatternMatching;

import java.math.BigDecimal;

public class UsingCaseToChooseAValueInJava {

    public enum AccountType {
        PLEB, MIDDLE_CLASS, RICHIE
    }

    public static void main(String[] args) {

        final BigDecimal balance = new BigDecimal("123.45");
        final AccountType accountType = AccountType.PLEB;
        final BigDecimal interestRate;
        switch (accountType) {
            case PLEB:
                interestRate = new BigDecimal("0.0001");
                break;
            case MIDDLE_CLASS:
                interestRate = new BigDecimal("0.001");
                break;
            case RICHIE:
                interestRate = new BigDecimal("0.01");
                break;
            default:
                throw new IllegalArgumentException("Unknown AccountType: " + accountType);
        }
        System.out.println("Interest for month = $" + balance.multiply(interestRate));
    }
}
