package lectures.part1basics

object CBNvsCBV extends App {
  // x is evaluated before the call, so the VALUE will be used inside the entire function definition
  def calledByValue(x: Long): Unit = {
    println("by value: " + x) // println("by value: " + 1012813634751)
    println("by value: " + x) // println("by value: " + 1012813634751)
  }

  // x is evaluated every time is called inside the function
  def calledByName(x: => Long): Unit = {
    println("by name: " + x) // println("by name: " + System.nanoTime())
    println("by name: " + x) // println("by name: " + System.nanoTime())
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()

  def printFirst(x: Int, y: => Int): Unit = println(x)

  //  printFirst(infinite(), 34) // -> CRASH
  printFirst(34, infinite()) // -> NO CRASH

  // CBV: value is computed before the call and the same value is used everywhere
  // CBN: expression is passed literally and is evaluated at every use within the function
}
