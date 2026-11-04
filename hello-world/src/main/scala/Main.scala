import scala.math.sqrt
import chapter2.Signum
import chapter2.Countdown
import chapter3.ArraySwitch
import chapter3.TaskFive
import chapter4.TaskOne
import chapter4.PropertiesTask


object Main extends App {

  /*testSignum()
  $testFor()
  $testCountdown()
  $testArraySwitch()
  $testGetAvg()
  PropertiesTask.printProperties() */
  

  val temp = TaskOne.getSales(0.3)

  println(temp)
  


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

def testArraySwitch() ={

  val temp1 = Array(2,3,5,7,11,12)
  val temp2 = Array(2,3,5,7,11)
  val temp3 = Array(2)

  println(s"ArraySwitch((2,3,5,7,11,12)) = ${ArraySwitch.arraySwitch(temp1).mkString(", ")}")
  println(s"ArraySwitch((2,3,5,7,11)) = ${ArraySwitch.arraySwitch(temp2).mkString(", ")}")
  println(s"ArraySwitch((2)) = ${ArraySwitch.arraySwitch(temp3).mkString(", ")}")
}

def testGetAvg() = {
  val avg1 = TaskFive.getAvg(Array(1, 2, 3, 4, 5))
  println(s"getAvg(Array(1, 2, 3, 4, 5)) = $avg1")
  assert(avg1 == 3.0, "Среднее должно быть 3.0")

  val avg2 = TaskFive.getAvg(Array(1.5, 2.5, 3.5))
  println(s"getAvg(Array(1.5, 2.5, 3.5)) = $avg2")
  assert(math.abs(avg2 - 2.5) < 0.0001, "Среднее должно быть 2.5")

  val avg3 = TaskFive.getAvg(Array(10L, 20L, 30L))
  println(s"getAvg(Array(10L, 20L, 30L)) = $avg3")
  assert(avg3 == 20.0, "Среднее должно быть 20.0")

  val avg4 = TaskFive.getAvg(Array(42))
  println(s"getAvg(Array(42)) = $avg4")
  assert(avg4 == 42.0, "Среднее одного элемента должно быть 42.0")

  val avg5 = TaskFive.getAvg(Array(-10, 0, 10))
  println(s"getAvg(Array(-10, 0, 10)) = $avg5")
  assert(avg5 == 0.0, "Среднее должно быть 0.0")

}

}
