package lectures.part2oop

object Objects {

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    val p1 = Person
    val p2 = Person
    println(p1 == p2)

    val bobbie = Person(mary, john)
  }

  class Person(val name: String) {
    // Instance-level functionality
  }

  // COMPANIONS

  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2

    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit

}
