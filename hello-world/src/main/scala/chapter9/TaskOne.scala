package chapter9
import scala.io.Source
import java.io.PrintWriter

object fileReader {
    def createReversedFile(srcPath: String, dstPath: String) ={
        val source = Source.fromFile(srcPath, "UTF8")

        try {
            val reversedLines = source.getLines.toList.reverse
            val writer = new PrintWriter(dstPath, "UTF-8")
            try {
                reversedLines.foreach(writer.println)
            } finally {
                writer.close()
            }
            println(s"Файл успешно перевернут")
        } finally {
            source.close()
        }
    }
}