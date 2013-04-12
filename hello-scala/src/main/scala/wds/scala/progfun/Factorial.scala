package wds.scala.progfun

/**
 *
 */
object Factorial {

  def main(args: Array[String]) {
    println(factorial(15))

    println(sum(x => x*x)(0, 4))
  }

  def factorial(n: Int) = {
    def loop(acc: Int, n: Int): Int = {
      if (n == 0) acc else loop(n * acc, n - 1)
    }
    loop(1, n)
  }

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }

}
