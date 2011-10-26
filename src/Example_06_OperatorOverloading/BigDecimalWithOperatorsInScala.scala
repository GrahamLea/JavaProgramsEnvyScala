package Example_06_OperatorOverloading

import java.math.BigDecimal
import java.math.BigDecimal._

object BigDecimalWithOperatorsInScala {

  class BigDecimalWithOperators(val value: BigDecimal) {
    def + (addend: BigDecimal): BigDecimal = value add addend
    def - (subtrahend: BigDecimal): BigDecimal = value subtract subtrahend
    def * (multiplicand: BigDecimal): BigDecimal = value multiply multiplicand
    def ^ (exponent: Int): BigDecimal = value pow exponent
    def to$: BigDecimal = value setScale(2, ROUND_HALF_UP)
  }

  implicit def bigDecimal2BigDecimalWithOperators(value: BigDecimal): BigDecimalWithOperators =
    new BigDecimalWithOperators(value)

  def main(args: Array[String]): Unit = {
    val principle = new BigDecimal("1000000")
    val interestRate = new BigDecimal("0.065")
    val depositTerm = 10
    val interestEarned = (principle * ((ONE + interestRate) ^ depositTerm) - principle) to$

    println("interestEarned = " + interestEarned)
  }
}