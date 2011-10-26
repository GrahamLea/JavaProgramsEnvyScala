package Example_03_Collections

object SummarisingCollectionsInScala {
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89)
    val output = numbers.foldLeft("")((s, n) => { s + (if (n % 2 == 0) "Even " else "Odd ") })
    System.out.println(output)
  }
}
