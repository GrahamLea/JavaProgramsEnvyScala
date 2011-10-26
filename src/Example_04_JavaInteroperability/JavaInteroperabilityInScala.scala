// Copyright (c) 2011 Belmont Technology Pty Ltd. All rights reserved.

package Example_04_JavaInteroperability

import java.io.File
import javax.imageio.ImageIO

object JavaInteroperabilityInScala {
  def main(args: Array[String]) {
    val tmp = new File(System.getProperty("java.io.tmpdir"))
    val home = new File(System.getProperty("user.home"))
    val outputDir = new File(tmp, "Example_04_JavaInteroperability")
    outputDir.mkdir()
    
    home.listFiles
      .filter(_.isDirectory)
      .map(_.listFiles)
      .filter(_ != null)
      .flatten
      .filter(_.getName.toLowerCase.endsWith(".jpg"))
      .toStream // Makes everything after here lazy, i.e. loads one image at a time
      .map(file => {
        println("Reading: " + file.getAbsolutePath)
        (file, ImageIO.read(file))
      }).
      foreach(fileAndImage =>  {
        val (file, image) = fileAndImage
        val newFilename = file.getName.splitAt(file.getName.lastIndexOf('.'))._1 + ".gif"
        val outputFile = new File(outputDir, newFilename)
        println("Writing " + outputFile.getAbsolutePath)
        ImageIO.write(image, "GIF", outputFile)
      })
  }
}