package chapter3

object TaskFive {
  def getAvg[T: Numeric](arr: Array[T]): Double = {
    require(arr.nonEmpty, "Array must not be empty")
    val num = implicitly[Numeric[T]]
    arr.map(num.toDouble).sum / arr.length
  }
}
