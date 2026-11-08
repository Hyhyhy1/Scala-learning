package chapter8

class Point private (private val packed: Long) extends AnyVal {
  
  def x: Int = (packed >> 32).toInt
  
  def y: Int = packed.toInt
}

object Point {
  def apply(x: Int, y: Int): Point = {

    val packedValue = (x.toLong << 32) | (y.toLong & 0xFFFFFFFFL)
    new Point(packedValue)
  }
}