package lecture_one_basics

object StringOps extends App{

  val str: String = "Holaaa , wazzup"
//  println(str.charAt(2))
//  println(str.substring(7,11))
//  println(str.split(" ").toList)

  // prepending and appending operators
  val aNumberString = "2"
  val aNumber = aNumberString.toInt
//  // only output
//  println('a' + aNumberString + 'z')
//  // prepending and appending > Type safety and Efficiency
//  println('a' +: aNumberString :+ 'z')
//  println(aNumberString)

  // S-INTERPOLATORS
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am  $age years old"
  val anotherGreeting = s"Hello, my name is $name and I am  ${age+1} years old"

  // F-INTERPOLATORS > you can use printf() like expressions > formatted expressions
  // They also check for type correctness

  // RAW-INTERPOLATORS > Literal > \n is printed as is, not NEWLINE inside RAW characters
  // Not if I pass a NEWLINE in a string_variable and println( raw"$string_variable")
}
