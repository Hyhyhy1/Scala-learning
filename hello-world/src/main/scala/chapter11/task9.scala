package chapter11

import java.io.File

class RichFile(val file: File)

object RichFile {
  def unapply(richFile: RichFile): Option[(String, String, String)] = {

    
    val path = Option(richFile.file.getParent).getOrElse("")
    val name = richFile.file.getName

    val temp = name.split("[.]")
    if (temp.length > 1) {
        val extension = temp(temp.length - 1)
        val nameWithoutExt = temp.slice(0, temp.length - 1).mkString(".")
        Some((path, nameWithoutExt, extension))
    } else {
        Some((path, "", ""))
    }
  }
}
