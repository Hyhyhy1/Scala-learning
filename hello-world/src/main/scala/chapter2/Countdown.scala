package chapter2

object Countdown {
  def countdown(n: Int) = {
    (n to 0 by -1).foreach(println)
  }
}
