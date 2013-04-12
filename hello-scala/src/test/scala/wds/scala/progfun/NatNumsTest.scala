package wds.scala.progfun

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class NatNumsTest extends FunSuite {
  test("numbers") {
    val one = new Succ(Zero)
    val two = new Succ(one)
    val three = new Succ(two)

    assert(three - two === one)
    assert((one + two).predecessor.predecessor.predecessor === Zero)
  }
}
