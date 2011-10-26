package Example_02_LessSyntax

import java.math.BigDecimal
import java.math.BigDecimal._

object ProceduralSyntaxInScala {
  def main(args: Array[String]): Unit = {
    val principle = new BigDecimal("1000000")
    val interestRate = new BigDecimal("0.065")
    val depositTerm = 10
    val interestEarned =
      principle multiply ((ONE add interestRate) pow depositTerm) subtract principle setScale(2, ROUND_HALF_UP)

    println("interestEarned = " + interestEarned)
  }
}