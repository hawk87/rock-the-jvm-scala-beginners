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


  // class parameters are NOT FIELDS
  // to convert a class parameter in a class field, add val or var to the class parameter

}

/*
Novel and a Writer

Writer: first name, surname, year of birth
  - method fullname

Novel: name, year of release, author
  - authorAge (age of the author at the year of release)
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel
*/


class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullName: String = s"$firstName $surname"
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge: Int = yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}

object WriterNovel {
  val author = new Writer("Anna", "Titova", 1996)
  val imposter = new Writer("Anna", "Titova", 1996)
  val novel = new Novel("A time lapse", 2019, author)

  println(author.fullName)

  println(novel.authorAge)
  println(novel.isWrittenBy(imposter))
  println(novel.copy(2020).authorAge)
}

/*
Counter class
  - receives an int value
  - method current count
  - method to increment/decrement by 1 => new Counter
  - overload inc/dec to receive an amount => new Counter
*/

class Counter(val count: Int = 0) {
  def inc: Counter = {
    println("incrementing")
    new Counter(count + 1) // immutability
  }

  def dec: Counter = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n == 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n == 0) this
    else dec.dec(n - 1)
  }

  def print: Unit = println(count)
}

object Counter {
  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}