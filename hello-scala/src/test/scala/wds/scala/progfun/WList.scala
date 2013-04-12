package wds.scala.progfun

import org.scalatest.FunSuite
import wds.scala.progfun.WList._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class WListTest extends FunSuite {

  trait TestList {
    val list = cons(1, cons(2, cons(3, cons(4, cons(5, singleton(6))))))
  }

  test("list") {
    new TestList {
      assert(nth(1, list) === 2)
    }
  }

  test("list-object") {
    new TestList {
      val l = WList(1, 2)
      assert(nth(1, l) === 2)
      val lp = l.prepend(0)
      assert(nth(1, lp) === 1)
      assert(nth(0, lp) === 0)
    }
  }

  test("out of bounds") {
    new TestList {
      intercept[IndexOutOfBoundsException] {
        nth(9, list)
      }
    }
  }
}
