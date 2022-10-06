package lecture_one_basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }
  // Scala can figure out the return type, except in recursive function

  def aParameterlessFunction(): Int = 42

  def aRepeatedFunction(aString: String, n: Int): String = {
    if(n==1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 4))

  // WHEN YOU NEED LOOPS, USE RECURSION

  // Use functions with side effects to print and stuff

  // CODE BLOCKS can hold auxiliary functions

  // Practice
  // 1. Greeting function
  def aGreetingFunction(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old"
  }

  // 2. Factorial function
  def Factorial(number: Int): Int = {
    if(number<=0) number
    else Factorial(number-1) * number
  }
  println(Factorial(5))

  // 3. Fibonacci function
  def Fibonacci(number: Int): Int = {
    if(number<=1) 1
    else Fibonacci(number-1) + Fibonacci(number-2)
  }

  // 4. Prime number classifier
  def isPrime(n:Int): Boolean = {
    def isPrimeUntil(t:Int): Boolean = {
      if(t<=1) true
      else n%t != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(n/2)
  }
}


