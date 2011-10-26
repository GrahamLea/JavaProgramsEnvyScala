// Copyright (c) 2011 Belmont Technology Pty Ltd. All rights reserved.

package Example_02_LessSyntax

import scala.collection._
import mutable.ListBuffer
object FunctionSyntaxInScala {
  def main(args: Array[String]) {
    val primes = List(1, 2, 3, 5, 7, 11, 13, 17, 19, 23)
    val possiblePrimes = applyForEach(primes, { _ * 2 - 1 } )
    
    println("possiblePrimes = " + possiblePrimes);
  }
  
  private def applyForEach(inputs: Seq[Int], function: (Int) => Int): Seq[Int] = {
    val result = new ListBuffer[Int]()
    for (input <- inputs) {
      result += function(input)
    }
    return result
  }
}