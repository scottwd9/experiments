package wds.scala.impatient

object Ch2 extends App {
  print("Name: ")
  val name = "Billy" //readLine()
  print("Age: ")
  val age = 29 //readInt()
  printf("Hi, my name is %s and I am %d years old.\n", name, age)

  var n = 2
  var r = 9
  val s = if (1 == 0) "a" else "b"
  if (n > 0) {
    r = r * n
    n -= 1
  }
  println(r)

  for (i <- 1 until 7 if odd(i))
    println(i)

  var sum = 0
  for (ch <- name) sum += ch
  println(sum)

  def odd(n: Int) = {
    (n % 2 == 1)
  }

  def fac(n: Int) = {
    var r: BigInt = BigInt(1)
    for (i <- 1 to n)
      r = r * BigInt(i)
    r
  }

  def signum(n: Int) = {
    if (n > 0)
      1
    else if (n == 0)
      0
    else
      -1
  }

  val fc = for (i <- 1 to 5)
    yield i

  println(fc)
  println(fac(4))

  for (i <- -5 to 9)
    println(signum(i))

}
