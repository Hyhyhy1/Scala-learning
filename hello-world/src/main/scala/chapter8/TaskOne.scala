package chapter8

class SavingsAccount(initialBalance: Double, interest: Double) extends BankAccount2(initialBalance) {
    private var counter = 0
    private var monthlyInterest = interest

    override def deposit(amount: Double): Double = {
        if (counter < 3) super.deposit(amount)
        else {
            super.deposit(amount)
            super.withdraw(1)
        }
        counter += 1
        currentBalance
    }

    override def withdraw(amount: Double): Double = {
        if (counter < 3) super.withdraw(amount)
        else {
            super.withdraw(amount)
            super.withdraw(1)
        }
        counter += 1
        currentBalance
    }

    def earnMonthlyInterest(): Double = {
        super.deposit(monthlyInterest * currentBalance)
        counter = 0
        currentBalance
    }
}

class CheckingAccount(initialBalance: Double) extends BankAccount2(initialBalance) {

    override def deposit(amount: Double) = {
        super.deposit(amount)
        super.withdraw(1)
        currentBalance
    }
    
    override def withdraw(amount: Double): Double = {
        super.withdraw(1)
        super.withdraw(amount)
        currentBalance
    }
}


class BankAccount2(initialBalance: Double) {
    private var balance = initialBalance
    def currentBalance = balance
    def deposit(amount: Double) = { balance += amount; balance }
    def withdraw(amount: Double) = { balance -= amount; balance }
}