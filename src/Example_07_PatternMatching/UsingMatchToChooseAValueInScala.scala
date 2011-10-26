package Example_07_PatternMatching

import java.math.BigDecimal
import Example_07_PatternMatching.UsingCaseToChooseAValueInJava.AccountType

object UsingMatchToChooseAValueInScala {

  import AccountType._

  def main(args: Array[String]): Unit = {
    val balance = new BigDecimal("123.45")
    val accountType = PLEB
    val interestRate = accountType match {
      case PLEB => new BigDecimal("0.0001")
      case MIDDLE_CLASS => new BigDecimal("0.001")
      case RICHIE => new BigDecimal("0.01")
      case _ => throw new IllegalArgumentException("Unknown AccountType: " + accountType)
    }
    System.out.println("Interest for month = $" + balance.multiply(interestRate))
  }

}