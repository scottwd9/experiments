package wds.scala.book

sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr

object Ch15 {

  def main(args: Array[String]) {
    println("Programming in Scala - Chapter 15")

    val a = Array[Any](new Var("variableName"),
      new Var("x"),
      new Number(1),
      new Number(9),
      (1, 2),
      "William",
      "blah blah blah")

    a.foreach(e => println(e match {
      case "William" => "Matched my name."
      case str: String => "some string"
      case Var(varName) => varName
      case Number(1) => "ONE!!!!111.."
      case Number(_) => "another number other than 1."
      case (x1, x2) => "tuples OMG (" + x1 + ", " + x2 + ")"
      case _ => "something"
    }))

    val b = Array(Some(101), None, Some(9))

    b.foreach(e => println {
      e match {
        case Some(x) => x
        case None => "AHHHHH"
      }
    })
    
    for(Some(n) <- b) println(n)
  }
}