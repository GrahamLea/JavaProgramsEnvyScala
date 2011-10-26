package Example_05_PimpMyLibrary

import java.io.File

object AugmentingClassesInScalaWithImplicitConversion {

  def main(args: Array[String]): Unit = {
    val home: File = new File(System.getProperty("user.home"))
    // java.io.File appears to have a find() function
    // List[File] appears to have an excluding() function
    for (file <- home.find(_.getName endsWith ".jpg").excluding("Temp")) {
      println(file)
    }
  }

  implicit def file2FileWithFind(file: File): FileWithFind = new FileWithFind(file)

  implicit def fileList2FileListWithExcluding(files: List[File]): FileListWithExcluding = new FileListWithExcluding(files)

  class FileWithFind(val file: File) {
    def find(filter: File => Boolean): List[File] = {
      file.listFiles match {
        case null => Nil
        case files => files.toList.filter(filter) ::: files.toList.filter(_.isDirectory).flatMap(_.find(filter))
      }
    }
  }

  class FileListWithExcluding(val files: List[File]) {
    def excluding(namePart: String): List[File] = files.filterNot(_.getAbsolutePath contains namePart)
  }

}
