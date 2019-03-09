package lectures.part2oop

object MethodNotations extends App {

  val mary = new Person("Mary", "Inception")
  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (works only with methods with single parameter) - syntactic sugar
  // prefix notation (unary operators) - syntactic sugar
  val x = -1 // equivalent with 1.unary_-
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS.
  // Akka actors have ! ?
  val y = 1.unary_-

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {

    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name what the heck?!"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    // Exercises

    def +(nickName: String): Person = new Person(s"$name ($nickName)", favoriteMovie)

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def learnsScala: String = this learns "Scala"

    def learns(subject: String): String = s"$name learns $subject"

    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }

  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation - syntactic sugar (only available to methods without parameters) - not really used
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  /*
    1.  Overload the + operator (receives a String and will return a new Person with a nickname)
        mary + "the rockstar" => new Person "Mary (the rockstar)"

    2.  Add an age to the Person class
        Add a unary + operator => new Person with the age + 1
        +mary => mary with the age incremented

    3.  Add a "learns" method in the Person class (receives a String and returns a String)
        => "Mary learns Scala"
        Add a learnsScala method, no parameters and calls the learns method with "Scala" as parameter
        Use it in postfix notation.

    4.  Overload the apply method, receives a number, returns a String
        mary.apply(2) => "Mary watched Incetion 2 times"
   */

  println((mary + "the rockstar") ())
  println((+mary).age)
  println(mary learnsScala)
  println(mary(10))
}
