package wds.scala.book

object Ch12 {

  class Point(val x: Int, val y: Int)

  trait Rectangular {
    def topLeft: Point

    def bottomRight: Point

    def left = topLeft.x

    def right = bottomRight.x

    def top = topLeft.y

    def bottom = bottomRight.y

    def width = bottomRight.x - topLeft.x

    def height = bottomRight.y - topLeft.y
  }

  class Rectangle(val topLeft: Point, val bottomRight: Point) extends Ordered[Rectangle] with Rectangular {
    def compare(that: Rectangle) = 0
  }

  def main(args: Array[String]) {
    val p1 = new Point(1, 1)
    val p2 = new Point(9, 7)

    val r = new Rectangle(p1, p2)

    println(r.top)
    println(r.right)
    println(r.bottom)
    println(r.left)
    println(r.height)
    println(r.width)
  }

}
