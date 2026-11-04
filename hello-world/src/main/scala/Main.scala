import scala.math.sqrt
import chapter2.Signum
import chapter2.Countdown
import chapter3.ArraySwitch
import chapter3.TaskFive
import chapter4.TaskOne
import chapter4.PropertiesTask
import chapter5.BankAccount


object Main extends App {

  /*testSignum()
  testFor()
  testCountdown()
  testArraySwitch()
  testGetAvg()
  PropertiesTask.printProperties()
  testBankAccount()*/

  


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

def testBankAccount() = {
  // 1. Проверка начального баланса
  val account1 = new BankAccount()
  assert(account1.balance == 0, "Начальный баланс должен быть 0")
  println(s"Начальный баланс: ${account1.balance}")

  // 2. Проверка начисления (deposit)
  account1.deposit(100)
  assert(account1.balance == 100, "После deposit(100) баланс должен быть 100")
  println(s"После deposit(100): ${account1.balance}")

  account1.deposit(50)
  assert(account1.balance == 150, "После deposit(50) баланс должен быть 150")
  println(s"После deposit(50): ${account1.balance}")

  // 3. Проверка списания (withdraw)
  account1.withdraw(30)
  assert(account1.balance == 120, "После withdraw(30) баланс должен быть 120")
  println(s"После withdraw(30): ${account1.balance}")

  account1.withdraw(120)
  assert(account1.balance == 0, "После withdraw(120) баланс должен быть 0")
  println(s"После withdraw(120): ${account1.balance}")

  // 4. Проверка разных экземпляров
  val account2 = new BankAccount()
  val account3 = new BankAccount()

  account2.deposit(500)
  account3.deposit(1000)

  assert(account2.balance == 500, "account2.balance должен быть 500")
  assert(account3.balance == 1000, "account3.balance должен быть 1000")
  assert(account2.balance != account3.balance, "Балансы разных аккаунтов не должны совпадать")
  println(s"account2.balance = ${account2.balance}, account3.balance = ${account3.balance}")

  // Изменение одного не должно влиять на другой
  account2.withdraw(200)
  assert(account2.balance == 300, "account2.balance должен быть 300")
  assert(account3.balance == 1000, "account3.balance должен остаться 1000")
  println(s"После изменения account2: account2=${account2.balance}, account3=${account3.balance}")

  val account4 = new BankAccount(1000)
  assert(account4.balance == 1000, "Начальный баланс через конструктор должен быть 1000")
  println(s"Начальный баланс через конструктор: ${account4.balance}")

  println("Все тесты BankAccount прошли!")
}

}
