package wds.scala.book

import java.io.{PrintWriter, File}
import java.util.Date

object Ch09 {
  def curriedSum(x: Int)(y: Int) = x + y

  def withPrintWriter(file: File, op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def withCurriedPrintWriter(file: File)(op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def main(args: Array[String]) {
    println("Chapter 9 - Programming in Scala")

    val inc = curriedSum(1) _
    println(inc(7))

    withPrintWriter(
      new File("out/not-curried"),
      writer => writer.println(new Date())
    )

    withCurriedPrintWriter(new File("out/curried")) {
      pw => pw.println(new Date())
    }
  }
}
