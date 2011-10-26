package Example_03_Collections

object SummingCollectionsOfNumbersInScala {
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6)
    val total = numbers.sum
    println("total = " + total);
  }
}
