package Example_07_PatternMatching

object DecisionBasedOnListContentsWithScala {

  case class Name(names: List[String])

  case class Languages(languages: List[String])

  private def interpret(strings: List[String]): Object = {
    strings match {
      case Nil => null
      case "Name:" :: tail => new Name(tail)
      case "Languages:" :: tail => new Languages(tail)
      case label :: _ => throw new IllegalArgumentException("Unknown label: " + label)
    }
  }

  def main(args: Array[String]): Unit = {
    println(interpret(List("Name:", "Graham", "Lea")))
    println(interpret(List("Languages:", "Java", "Scala", "Javascript", "HTML", "SQL", "Shell", "etc.")))
    println(interpret(List()))
  }
}