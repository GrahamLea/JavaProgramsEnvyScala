package Example_01_TypeInference

import java.math.BigInteger
import collection.mutable.HashMap

object TypeInferenceScala {
  def main(args: Array[String]): Unit = {
    val profit = new BigInteger("12345678.99")
    val customersById = new HashMap[String, Customer]
    var strings = List("one", "two", "three")
//    strings += profit // doesn't compile: "type mismatch, found BigInteger, expected String
  }
}

class Customer {
}