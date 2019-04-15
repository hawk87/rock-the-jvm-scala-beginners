package lectures.part3fp

object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  val aTuple = (2, "hello, Scala") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, Scala", 2)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1)
  // a -> b syntactic sugar for (a, b)
  println(phoneBook)

  // map ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))
  println(phoneBook("Mary")) // NoSuchElementException if not .withDefaultValue

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phoneBook + newPairing
  println(newPhonebook)

  // functionals on maps
  // map, flatMap, filter

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phoneBook.filterKeys(x => x.startsWith("J")))
  // mapValues
  println(phoneBook.mapValues(number => "0245-" + number))

  // conversions to other collections
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  /*
    1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900? (lowerCase map)
    2. Overly simplified social network based on maps
        Person = String
        - add a person to the network
        - remove
        - friend (mutual)
        - unfriend (unmutual)

        Network = Map between each name and a list of friends

        - number of friends of a person
        - person with most friends
        - how many people have NO friends
        - if there is a social connection between two people (direct or not)
   */
}