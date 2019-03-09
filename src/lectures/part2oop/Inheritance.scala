package lectures.part2oop

object Inheritance extends App {

  val cat = new Cat
  val dog = new Dog("K9")
  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  cat.crunch

  // single class inheritance
  sealed class Animal {
    val creatureType: String = "wild"

    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  dog.eat
  println(dog.creatureType)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    //    override val creatureType: String = "domestic"
    override def eat: Unit = {
      super.eat
      println("crunch, crunch")
    }
  }

  unknownAnimal.eat

  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend class in THIS FILE, prevent extension in other files
}
