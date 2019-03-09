package lectures.part2oop

object Generics extends App {

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]
  val emptyListOfIntegers = MyList.empty[Int]
  val animal: Animal = new Cat

  // generic methods
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
  val cage = new Cage(new Dog)

  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Animal
     */
  }

  class MyMap[Key, Value]

  // variance problem
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // animalList.add(new Dog) ? HARD QUESTION => we return a list of Animals

  // Q: Does a List of Cat extend a List of Animal?
  // 1. Yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]

  //  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] // ERROR

  // 2. No = INVARIANCE
  class InvariantList[A]

  // 3. HELL NO! = CONTRAVARIANCE
  class ContravariantList[-A]

  // bounded types
  class Cage[A <: Animal](animal: A)

  class Car

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  // generic type needs proper bounded type
  //  val newCage = new Cage(new Car)

  // expand MyList to be generic

}
