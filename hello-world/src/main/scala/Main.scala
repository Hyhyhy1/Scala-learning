import scala.math.sqrt
import chapter2.Signum
import chapter2.Countdown
import chapter3.ArraySwitch
import chapter3.TaskFive
import chapter4.TaskOne
import chapter4.PropertiesTask
import chapter5.BankAccount
import chapter8.{BankAccount2, CheckingAccount}


object Main extends App {

  /*testSignum()
  testFor()
  testCountdown()
  testArraySwitch()
  testGetAvg()
  PropertiesTask.printProperties()
  testBankAccount()*/
  testBankAccount2
  testCheckingAccount
  testInstanceIsolation

  


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

  def testBankAccount2() = {
    println("=== Тесты BankAccount ===")

    // 1. Начальный баланс
    val acc1 = new BankAccount2(100)
    assert(acc1.currentBalance == 100, "Начальный баланс должен быть 100")
    println(s"Начальный баланс: ${acc1.currentBalance}")

    // 2. Пополнение
    acc1.deposit(50)
    assert(acc1.currentBalance == 150, "После deposit(50) баланс должен быть 150")
    println(s"После deposit(50): ${acc1.currentBalance}")

    // 3. Снятие
    acc1.withdraw(30)
    assert(acc1.currentBalance == 120, "После withdraw(30) баланс должен быть 120")
    println(s"После withdraw(30): ${acc1.currentBalance}")

    // 4. Снятие всего баланса
    acc1.withdraw(120)
    assert(acc1.currentBalance == 0, "После withdraw(120) баланс должен быть 0")
    println(s"После полного снятия: ${acc1.currentBalance}")

    // 5. Отрицательный баланс (если не запрещён)
    acc1.withdraw(50)
    assert(acc1.currentBalance == -50, "Баланс может уйти в минус")
    println(s"Отрицательный баланс: ${acc1.currentBalance}")

    println("Все тесты BankAccount прошли!\n")
  }

  def testCheckingAccount() = {
    println("=== Тесты CheckingAccount ===")

    // 1. Начальный баланс
    val acc1 = new CheckingAccount(100)
    assert(acc1.currentBalance == 100, "Начальный баланс должен быть 100")
    println(s"Начальный баланс: ${acc1.currentBalance}")

    // 2. Пополнение с комиссией $1
    acc1.deposit(50)
    // 100 + 50 - 1 (комиссия) = 149
    assert(acc1.currentBalance == 149, s"После deposit(50) баланс должен быть 149, а не ${acc1.currentBalance}")
    println(s"После deposit(50) с комиссией: ${acc1.currentBalance}")

    // 3. Снятие с комиссией $1
    acc1.withdraw(30)
    // 149 - 30 - 1 (комиссия) = 118
    assert(acc1.currentBalance == 118, s"После withdraw(30) баланс должен быть 118, а не ${acc1.currentBalance}")
    println(s"После withdraw(30) с комиссией: ${acc1.currentBalance}")

    // 4. Несколько операций подряд
    acc1.deposit(100)  // 118 + 100 - 1 = 217
    acc1.withdraw(17)  // 217 - 17 - 1 = 199
    assert(acc1.currentBalance == 199, s"После серии операций баланс должен быть 199, а не ${acc1.currentBalance}")
    println(s"После серии операций: ${acc1.currentBalance}")

    println("Все тесты CheckingAccount прошли!\n")
  }

  def testInstanceIsolation() = {
    println("=== Тест изоляции экземпляров ===")

    // 1. Два независимых BankAccount
    val acc1 = new BankAccount2(100)
    val acc2 = new BankAccount2(200)

    acc1.deposit(50)
    assert(acc1.currentBalance == 150, "acc1 должен быть 150")
    assert(acc2.currentBalance == 200, "acc2 должен остаться 200")
    println(s"acc1=${acc1.currentBalance}, acc2=${acc2.currentBalance} (независимы)")

    // 2. Два независимых CheckingAccount
    val check1 = new CheckingAccount(100)
    val check2 = new CheckingAccount(200)

    check1.deposit(50)  // 100 + 50 - 1 = 149
    assert(check1.currentBalance == 149, "check1 должен быть 149")
    assert(check2.currentBalance == 200, "check2 должен остаться 200")
    println(s"check1=${check1.currentBalance}, check2=${check2.currentBalance} (независимы)")

    // 3. Смешанные типы — тоже независимы
    val bank = new BankAccount2(500)
    val checking = new CheckingAccount(500)

    bank.deposit(100)     // 500 + 100 = 600 (без комиссии)
    checking.deposit(100) // 500 + 100 - 1 = 599 (с комиссией)

    assert(bank.currentBalance == 600, "BankAccount без комиссии")
    assert(checking.currentBalance == 599, "CheckingAccount с комиссией")
    println(s"BankAccount=${bank.currentBalance}, CheckingAccount=${checking.currentBalance} (разное поведение)")

    // 4. Изменение одного не влияет на другой
    check1.withdraw(49)  // 149 - 49 - 1 = 99
    assert(check1.currentBalance == 99, "check1 должен быть 99")
    assert(check2.currentBalance == 200, "check2 должен остаться 200")
    println(s"После изменения check1: check1=${check1.currentBalance}, check2=${check2.currentBalance}")
  }

}
