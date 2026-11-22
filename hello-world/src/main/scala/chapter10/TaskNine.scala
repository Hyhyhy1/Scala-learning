package chapter10
import java.io.InputStream

trait Buffered extends InputStream {
  private val buffer = new Array[Byte](1024)
  private var pos = 0
  private var count = 0

  override def read(): Int = {
    if (pos >= count) {
      count = super.read(buffer, 0, buffer.length)
      pos = 0
      
      if (count == -1) return -1
    }
    
    val result = buffer(pos) & 0xFF
    pos += 1
    result
  }
}
