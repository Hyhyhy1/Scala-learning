package chapter9
import scala.io.Source
import java.io.PrintWriter

object tabReplacer {
    def replaceTabs(srcPath: String, dstPath: String, tabSize: Int): Unit = {
        val source = Source.fromFile(srcPath, "UTF-8")
        val content = try { source.getLines.mkString("\n") }
        finally { source.close() }

        val processed = content.linesIterator.map(replace(_, tabSize)).mkString("\n")

        val writer = new PrintWriter(dstPath, "UTF-8")
        try { writer.write(processed)}
        finally {writer.close()}
    }

    private def replace(text: String, tabSize: Int): String = {
        var builder = new StringBuilder
        var pos = 0

        for (ch <- text){
            if (ch == '\t') {
                val spacesCount = tabSize - (pos % tabSize)
                builder.append(" " * spacesCount)
                pos += spacesCount
            } else {
                builder.append(ch)
                pos += 1
            }
        }
        
        builder.toString()
    }
}