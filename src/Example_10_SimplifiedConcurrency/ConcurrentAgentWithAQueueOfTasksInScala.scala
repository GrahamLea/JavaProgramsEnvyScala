package Example_10_SimplifiedConcurrency

import actors.Actor._

// Copyright (c) 2011 Belmont Technology Pty Ltd. All rights reserved.

object ConcurrentAgentWithAQueueOfTasksInScala {
  def main(args: Array[String]) {
    class Customer(val name: String)

    val calculatorAgent = actor {
      loop {
        react {
          case customer: Customer => {
            println("Calculating stuff for " + customer.name + " ... ")
            Thread.sleep(1000)
            println("    " + customer.name + " Done")
          }
          case "END" => {
            println("Exiting")
            System.exit(0)
          }
        }
      }
    }

    calculatorAgent ! new Customer("Graham")
    calculatorAgent ! new Customer("Pedro")
    calculatorAgent ! new Customer("Alex")
    calculatorAgent ! "END"
    println("Finished queueing tasks")
 
  }
}