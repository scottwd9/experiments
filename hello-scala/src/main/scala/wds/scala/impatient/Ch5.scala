package wds.scala.impatient

object Ch5 extends App {

  class Counter {
    private var v: BigInt = 0

    def increment() {
      v += 1
    }

    def value = v
  }

  class BankAccount {
    private var b: Double = 0.0

    def balance = b

    def deposit(amount: Double) {
      b += amount
    }

    def withdraw(amount: Double) {
      b -= amount
    }
  }

  val c = new Counter
  val account = new BankAccount
  println(account.balance)
  account.deposit(9)
  account.withdraw(2)
  println(account.balance)

  println(c.value)
  for (i <- 1 to 100)
    c.increment()
  println(c.value)
}
