package wds.scala.impatient

object Ch8 {
  def main(args: Array[String]) {
    val billy = Employee("Billy", 29, 85000)
    println(billy.name)
  }

  class Person(val name: String, val age: Int)
  object Person {
    def apply(name: String, age: Int) =
      new Person(name, age)
  }

  class Employee(name: String, age: Int, val salary: Double) extends Person(name, age)
  object Employee {
    def apply(name: String, age: Int, salary: Double) =
      new Employee(name, age, salary)
  }
}