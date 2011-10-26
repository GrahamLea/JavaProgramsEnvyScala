package Example_08_NamedAndDefaultParameters

object CreatingComplexObjectInScalaWithNamedParameters {

  class Customer(val name: String, val address: String, val age: Int, val salary: Int);

  def main(args: Array[String]): Unit = {
    val customer1 =
      new Customer(name = args(0),
                   address = args(1),
                   age = Integer.parseInt(args(2)),
                   salary = Integer.parseInt(args(3)))
  }

}