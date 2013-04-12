package wds.scala.progfun

import java.util.NoSuchElementException

trait WList[+T] {
  def isEmpty: Boolean

  def head: T

  def tail: WList[T]

  def prepend[U >: T](elem: U): WList[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: WList[T]) extends WList[T] {
  def isEmpty: Boolean = false
}

object Nil extends WList[Nothing] {
  def isEmpty: Boolean = true

  def head: Nothing = throw new NoSuchElementException("Nil.head")

  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object WList {
  def apply[T]() = Nil

  def apply[T](x: T) = new Cons(x, Nil)

  def apply[T](x: T, y: T) = new Cons(x, new Cons(y, Nil))

  def singleton[T](elem: T) = new Cons(elem, Nil)

  def cons[T](elem: T, rest: WList[T]) = new Cons[T](elem, rest)

  def nth[T](n: Int, l: WList[T]): T =
    if (n < 0 || l.isEmpty) throw new IndexOutOfBoundsException("bad")
    else if (n == 0) l.head
    else nth(n - 1, l.tail)

}

