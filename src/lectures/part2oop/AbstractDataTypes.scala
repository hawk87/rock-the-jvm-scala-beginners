package lectures.part2oop

object AbstractDataTypes extends App {

  val dog = new Dog
  val croc = new Crocodile

  // traits
  trait Carnivore {
    val preferredMeal: String = "fresh meat"

    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  // abstract
  abstract class Animal {
    val creatureType: String = "wild"

    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    def eat: Unit = println("crunch crunch")
  }

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"

    def eat: Unit = println("nomnomnom")

    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behaviour, abstract class = "thing"
}
