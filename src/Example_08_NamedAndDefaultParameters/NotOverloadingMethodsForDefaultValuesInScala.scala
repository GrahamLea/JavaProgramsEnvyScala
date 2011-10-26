package Example_08_NamedAndDefaultParameters

import java.math.BigDecimal
import java.math.BigDecimal._

object NotOverloadingMethodsForDefaultValuesInScala {

  import Example_06_OperatorOverloading.BigDecimalWithOperatorsInScala._

  def priceOf(unitPrice: BigDecimal, units: Int = 1, discountRate: BigDecimal = ZERO, salesTaxRate: BigDecimal = ZERO): BigDecimal = {
    (unitPrice * new BigDecimal(units) * (ONE - discountRate) * (ONE + salesTaxRate)) to$
  }

  def main(args: Array[String]): Unit = {
    val price = new BigDecimal("7.50")
    val units = 2
    val discount = new BigDecimal("0.05")
    val taxRate = new BigDecimal("0.12")
    println(priceOf(price, units, discount, taxRate))
    println(priceOf(price, units, discount))
    println(priceOf(price, units))
    println(priceOf(price, units, salesTaxRate = taxRate))
    println(priceOf(price, discountRate = discount, salesTaxRate = taxRate))
    println(priceOf(price, discountRate = discount))
    println(priceOf(price, salesTaxRate = taxRate))
  }
}