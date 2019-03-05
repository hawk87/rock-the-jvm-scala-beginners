package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||
  // Instructions (DO) vs Expressions (VALUE)
  val aCondition = true
  aVariable += 3 // also works with -= *= /=
  println(aVariable)
  val aConditionedValue = if (aCondition) 5 else 3
  // EVERYTHING in Scala is an Expression!
  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aConditionedValue)
  println(if (aCondition) 5 else 3)
  println(1 + 3)
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z < 2) "hello" else "goodbye"
  }
  while (i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN.
  val someValue = {
    2 < 3
  }
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  // Code blocks
  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }

  // 1. difference between "hello world" and println("hello world")?
  // "hello world" is a String, while println("hello world") is an expression -> side effect -> returns Unit
  // 2.
  var aVariable = 2
  println(someValue)
  var i = 0
  println(someOtherValue)

}
