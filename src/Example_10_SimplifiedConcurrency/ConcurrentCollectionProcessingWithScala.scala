package Example_10_SimplifiedConcurrency

// Copyright (c) 2011 Belmont Technology Pty Ltd. All rights reserved.

object ConcurrentCollectionProcessingWithScala {

  def main(args: Array[String]) {

    class Customer(val name: String)

    val customers = List(new Customer("Graham"), new Customer("Pedro"), new Customer("Alex"))
    // If you only have Scala 2.8.x, comment out this example and the rest should compile fine.
    customers.par.foreach( customer => {
      println("Calculating stuff for " + customer.name + " ... ")
      Thread.sleep(1000)
      println("    " + customer.name + " Done")
    })
    println("foreach() returned")

  }
}