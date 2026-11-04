package chapter4
import scala.collection.JavaConverters._
import scala.collection.convert.AsScalaExtensions

object PropertiesTask {
    def printProperties() = {
        val props = System.getProperties().asScala
        val maxLen = props.keys.maxBy(_.length()).length()
        for ((key, value) <- props) {
            println(String.format(s"%-${maxLen}s | %s", key, value))
        }
    }

}
