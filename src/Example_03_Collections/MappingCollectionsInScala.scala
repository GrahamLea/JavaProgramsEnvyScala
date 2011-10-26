package Example_03_Collections

object MappingCollectionsInScala {
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6)
    val numberStatements = numbers.map(n => { n + " is " + (if (n % 2 != 0) "odd" else "even") })
    for (val s <- numberStatements)
      println(s)
  }
}
