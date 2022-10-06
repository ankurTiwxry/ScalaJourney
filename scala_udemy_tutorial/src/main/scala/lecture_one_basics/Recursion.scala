package lecture_one_basics

object Recursion extends App{

  // regular recursion
  def RegularFactorial(n: Int): Int = {
    if (n <= 0) 1
    else n * RegularFactorial(n-1)
  }

  // Stack Frame Tail End Recursion
  def TailEndFactorial(n: Int): BigInt = {
    @scala.annotation.tailrec
    def TailEndHelper(t: Int, accumulator: BigInt): BigInt = {
      if (t<=1) accumulator
      else TailEndHelper(t - 1, t * accumulator)
    }
    TailEndHelper(n,1)
  }

//  println("Reg: " + RegularFactorial(5))
//  println("Tem: " + TailEndFactorial(15))

  // Practice code
  // 1. Concatenate a string n times
  def TailEndStringConcatenation(s: String, n: Int): String = {
    @scala.annotation.tailrec
    def Helper( concatenation: String, t: Int): String = {
      if(t<=1) concatenation
      else Helper(concatenation + s, t-1)
    }
    Helper(s, n)
  }

//  println("Cct: " + TailEndStringConcatenation("Hello\n", 8))

  // 2. IsPrime as tail recursive
  def TailEndIsPrime(n: Int): Boolean = {
    @scala.annotation.tailrec
    def Helper(t: Int, isStillPrime: Boolean): Boolean = {
      if(!isStillPrime) false
      else if (t <= 1) true
      else Helper(t-1, n%t!=0 && isStillPrime)
    }
    Helper(n / 2, true)
  }

  println("IsPrime: " + TailEndIsPrime(31))

  // 3. Tail recursive fibonacci
  def TailEndFibonacci(n: Int): Int = {
    @scala.annotation.tailrec
    def Helper(i: Int, last: Int, next_to_last: Int): Int = {
      if(i>=n) last
      else Helper(i+1, last + next_to_last, last)
    }

    if(n<=2) 1
    else Helper(2, 1, 1)
  }

  println("Fib: " + TailEndFibonacci(8))

}
