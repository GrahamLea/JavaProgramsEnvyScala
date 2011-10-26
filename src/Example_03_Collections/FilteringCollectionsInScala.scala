package Example_03_Collections

object FilteringCollectionsInScala {
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6)
    val oddNumbers = numbers.filter(_ % 2 != 0)
    println("oddNumbers = " + oddNumbers);
  }
}
