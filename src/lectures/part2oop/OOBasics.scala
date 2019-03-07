package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.x)
  person.greet("Daniel")
  person.greet()
}

// constructor
class Person(name: String, val age: Int) {
  // body
  val x = 2 // field

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors (they can only have a constructor as their implementation)
  def this(name: String) = this(name, 0)
}

// class parameters are NOT FIELDS
// to convert a class parameter in a class field, add val or var to the class parameter