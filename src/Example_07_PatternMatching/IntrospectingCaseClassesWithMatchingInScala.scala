package Example_07_PatternMatching

// Copyright (c) 2011 Belmont Technology Pty Ltd. All rights reserved.

object IntrospectingCaseClassesWithMatchingInScala {

  case class Language(name: String, hasClosures: Boolean, version: Double)

  private def shouldILearn(language: Language): String = {
    language match {
      case Language("Scala", _, _) => "Scala!? For sure!"
      case Language(_, true, _) => "Has closures. Could be alright."
      case Language("Java", _, v) if (v >= 1.5) => "If you've got no better options..."
      case Language("Java", _, 1.4) => "Depends. How much are they going to pay you?"
      case Language("Java", _, _) => "Urrr... maybe change careers?"
      case _ => "Sorry. Don't know anything about that."
    }
  }

  def main(args: Array[String]) {
    val languages = List(
      Language("Scala", true, 2.9),
      Language("Scala", true, 2.8),
      Language("Ruby", true, 1.9),
      Language("Javascript", true, 1.8),
      Language("Java", false, 1.6),
      Language("Java", false, 1.4),
      Language("Java", false, 1.2),
      Language("Visual Basic", false, 2010)
    )

    for (val language <- languages) {
      println("Should I learn " + language.name + " " + language.version + " ?")
      println("    " + shouldILearn(language) + "\n")
    }
  }
}