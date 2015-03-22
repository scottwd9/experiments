object Hello {
  def main(args: Array[String]): Unit = {
    println(formatResult("abs", -42, abs))
    println(formatResult("fac", 7, factorial))
    println(formatResult("fib", 13, fib))

    println(isSorted(
      Array(3, 2, 1),
      (a: Int, b: Int) => a > b)
    )
  }

  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n - 1, n * acc)

    go(n, 1)
  }

  def fib(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, crnt: Int, next: Int): Int =
      if (n <= 0) crnt
      else go(n - 1, next, next + crnt)

    go(n, 0, 1)
  }

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean) = {
    @annotation.tailrec
    def loop(n: Int): Boolean =
      if (n >= as.length - 1) true
      else if (!ordered(as(n), as(n + 1))) false
      else loop(n + 1)

    loop(0)
  }

  private def formatResult(name: String, x: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d"
    msg.format(name, x, f(x))
  }

  def partial1[A, B, C](a: A, f: (A, B) => C): B => C =
    b => f(a, b)

  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    a => b => f(a, b)

  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a, b) => f(a)(b)

  def compose[A,B,C](f: B => C, g: A => B): A => C =
    a => f(g(a))
}
