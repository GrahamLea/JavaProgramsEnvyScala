package Example_08_NamedAndDefaultParameters;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;

public class OverloadingMethodsForDefaultValuesInJava {

    public static BigDecimal priceOf(BigDecimal unitPrice, int units, BigDecimal discountRate, BigDecimal salesTaxRate) {
        return unitPrice.multiply(new BigDecimal(units))
                    .multiply(ONE.subtract(discountRate))
                    .multiply(ONE.add(salesTaxRate))
                    .setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal priceOf(BigDecimal unitPrice, int units, BigDecimal discountRate) {
        return priceOf(unitPrice, units, discountRate, BigDecimal.ZERO);
    }

    // Doesn't compile. Can't have a default discountRate with specified salesTaxRate due to unique signature restrictions
//    public static BigDecimal priceOf(BigDecimal unitPrice, int units, BigDecimal salesTaxRate) {
//        return priceOf(unitPrice, units, BigDecimal.ZERO, salesTaxRate);
//    }

    public static BigDecimal priceOf(BigDecimal unitPrice, int units) {
        return priceOf(unitPrice, units, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    public static BigDecimal priceOf(BigDecimal unitPrice, BigDecimal discountRate, BigDecimal salesTaxRate) {
        return priceOf(unitPrice, 1, discountRate, salesTaxRate);
    }

    public static BigDecimal priceOf(BigDecimal unitPrice, BigDecimal discountRate) {
        return priceOf(unitPrice, 1, discountRate, ZERO);
    }

    // Doesn't compile. Can't have a default discountRate with specified salesTaxRate due to unique signature restrictions
//    public static BigDecimal priceOf(BigDecimal unitPrice, BigDecimal salesTaxRate) {
//        return priceOf(unitPrice, 1, ZERO, salesTaxRate);
//    }

    public static void main(String[] args) {
        int units = 2;
        BigDecimal price = new BigDecimal("7.50");
        BigDecimal discount = new BigDecimal("0.05");
        BigDecimal taxRate = new BigDecimal("0.12");
        System.out.println(priceOf(price, units, discount, taxRate));
        System.out.println(priceOf(price, units, discount));
        System.out.println(priceOf(price, units));
        System.out.println(priceOf(price, units, ZERO, taxRate));
        System.out.println(priceOf(price, discount, taxRate));
        System.out.println(priceOf(price, discount));
        System.out.println(priceOf(price, ZERO, taxRate));
    }

}
