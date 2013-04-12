package wds.scala.book

class BankAccount(private var bal: Int = 0) {
  def balance: Int = bal

  def printBalance() {
    println(bal)
  }

  def deposit(amount: Int) {
    require(amount > 0)
    bal += amount
  }
  def withdraw(amount: Int): Boolean =
    if (amount > bal) false else {
      bal -= amount
      true
    }
}

object Ch18 extends App {
  val account = new BankAccount()
  account.deposit(100)
  account.deposit(91)
  account.withdraw(50)
  account.withdraw(1000)
  println(account.balance)
}