package `chapter2`

object Signum {
  def apply(num: Double): Int = {
    if (num > 0) 1
    else if (num == 0) 0
    else -1
  }
}
