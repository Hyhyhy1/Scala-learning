package chapter5

class BankAccount(initialBalance: Int = 0) {
    private[this] var _balance = initialBalance

    def balance: Int = _balance

    def deposit(value: Int) = {
        _balance += value
    }

    def withdraw(value: Int) = {
        _balance -= value
    }
}
