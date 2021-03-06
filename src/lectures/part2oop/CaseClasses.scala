package lectures.part2oop

object CaseClasses extends App {

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  // 3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim)
  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim == jim2)
  // 5. CCs have companion objects
  val thePerson = Person
  println(jim3)
  val mary = Person("Mary", 23)

  /*
    equals, hashCode, toString
   */
  case class Person(name: String, age: Int)

  // 6. CCs are serializable
  // Akka

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
    Expand MyList - use case classes and case objects
   */

}
