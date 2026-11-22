package chapter9

import java.io.File

object ScalaFileCounter {
  
  def countScalaFiles(dir: File): Int = {
    val children = Option(dir.listFiles()).getOrElse(Array.empty)
    
    val currentCount = children.count(f => f.isFile && f.getName.endsWith(".scala"))
    
    val subDirsCount = children
      .filter(_.isDirectory)
      .map(subDir => countScalaFiles(subDir))
      .sum
      
    currentCount + subDirsCount
  }
}