package wds.scala.book

object Ch16 extends App {
  def reverseList[T](list: List[T]) =
  (List[T]() /: list){(ys, y) => y :: ys}

  val nums = List(1, 2, 3, 4, 5, 6)
  val words = List("i", "have", "a", "belly", "button")

  val sumOfNums = nums.foldLeft(0)(_ + _)
  println((0 /: nums) (_ + _))
  println((nums :\ 0) (_ + _))
  println(nums.foldRight(0) (_ + _))
  println(sumOfNums)

  val incrOfNums = nums map (_ + 1)
  println(incrOfNums)

  val revWordsLetters = words flatMap (_.toList.reverse)
  println(revWordsLetters)

  val reverseWords = reverseList(words)
  println(reverseWords)
}
