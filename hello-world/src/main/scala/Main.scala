import scala.math.sqrt
import chapter2.Signum
import chapter2.Countdown


object Main extends App {

  testSignum()
  testFor()
  testCountdown()




def testSignum() = {
  assert(Signum(1) == 1, "Signum(1) должен быть 1")
  println(s"Signum(1) = ${Signum(1)}")

  assert(Signum(0) == 0, "Signum(0) должен быть 0")
  println(s"Signum(0) = ${Signum(0)}")

  assert(Signum(-83.2) == -1, "Signum(-83.2) должен быть -1")
  println(s"Signum(-83.2) = ${Signum(-83.2)}")
}

def testFor () = {
  (10 to 0 by -1).foreach(println)
}

def testCountdown () = {
  Countdown.countdown(5)
}

}

