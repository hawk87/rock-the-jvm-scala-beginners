package playground

object Recursion extends App {
  val n = 131

  /** Concatenate the string n times. */
  def repeat(s: String, n: Int): String =
    if (n == 1) s
    else s + repeat(s, n - 1)

  //  println(repeat("hello", 5))
  println(repeat_tr("hello", 5))

  /** Concatenate the string n times, tail recursive implementation. */
  def repeat_tr(s: String, n: Int): String = {
    def auxRepeat(accumulator: String, x: Int): String =
      if (x == 1) accumulator
      else auxRepeat(accumulator + s, x - 1)

    auxRepeat(s, n)
  }

  /** Primality test, tail recursive implementation. */
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t == 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  println(s"$n is prime")

  /** Fibonacci number, double recursion implementation. */
  def fib(n: Int): Int = {
    if (n == 0) 0
    else if (n == 1) 1
    else fib(n - 1) + fib(n - 2)
  }

  /** Fibonacci number, tail recursive implementation. */
  def fib_tr(n: Int): BigInt = {
    def auxFib(x: Int, acc1: BigInt, acc2: BigInt): BigInt = {
      if (x == 0) acc1
      else if (x == 1) acc2
      else auxFib(x - 1, acc2, acc1 + acc2)
    }

    auxFib(n, 0, 1)
  }

  /*
     f(8) = f(7) + f(6) => 13 + 8 = 21
     f(7) = f(6) + f(5) => 8 + 5 = 13
     f(6) = f(5) + f(4) => 5 + 3 = 8
     f(5) = f(4) + f(3) => 3 + 2 = 5
     f(4) = f(3) + f(2) => 2 + 1 = 3
     f(3) = f(2) + f(1) => 2
     f(2) = f(1) + f(0) => 1
     f(1) = 1
     f(0) = 0
   */

  println(s"fib: ${fib(8)}") // It should be 21 => 1,1,2,3,5,8,13,21
}
