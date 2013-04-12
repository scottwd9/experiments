package wds.scala.book

import scala.collection.mutable.ListBuffer

object Ch17 {

  def main(args: Array[String]) = {
    //Seq - List, Array, ListBuffer, String (via String
    //Lists are immutable
    val fruits = List("apples", "oranges", "bananas")
    val something = "strawberries" :: fruits.drop(1)

    matchList(fruits)
    matchList(something)

    //ListBuffer gives constant time append/prepend
    val lb = ListBuffer(1)
    lb += 2
    3 +=: lb
    println(lb.toList)

    println(hasUpperCaseLetter("i have a belly buttoN"))

    val map = Map("billy" -> 29, "sara" -> 24)
    println(map)
    map.keys.foreach(n => println(map(n)))

    val tuple = ("google", "http://google.com")
    val (website, address) = tuple
    println(website)
    println(address)
  }

  def hasUpperCaseLetter(str: String) = str.exists(_.isUpper)

  def matchList(seq: Seq[String]) = {
    seq match {
      case "strawberries" :: tail => println(1)
      case _ => println(0)
    }
  }
}
