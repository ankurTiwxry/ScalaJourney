package object_oriented_scala

object MethodNotations extends App{

  class Person(val name: String, val age: Int, fav_movie: String) {
    def likes(movie:String): Boolean = movie == fav_movie
    def hangsOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name"

    // practice code ---------------------------------------------------------
    def unary_+ : Person = new Person(this.name, {this.age}+1, this.fav_movie)
    def learns(activity: String): String = s"${this.name} learns ${activity}"
    def learnsScala(): String = learns("Scala")
    def apply(count: Int): String = s"${this.name} watched ${this.fav_movie} ${count} times!"
  }

  // SYNTACTIC SUGAR xD
  // The code is in equivalent pairs

  // INFIX NOTATION = operator notation :: works only with one parametered methods -------------------------

  val mary = new Person("Mary", 20,"Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")   // equivalent

  // "operators" in scala
  val tom = new Person("Tom", 24, "Fight Club")
  println(mary.hangsOutWith(tom))   // equivalent
  println(mary hangsOutWith tom)    // here hangsOutWith acts like an operator between mary and tom

  // scala naming can have methods called "+" or other special characters : very freeing
  // even mathematical operators behave the same way
  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS! ------------------------------------------------------------------- IMPORTANT

  // PREFIX NOTATION
  val x = -1
  val y = 1.unary_-   // equivalent
  // unary prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)   // equivalent

  // apply method
  println(mary.apply())
  println(mary())   // equivalent

  // POSTFIX NOTATION : for functions without parameters
  // println(mary.isAlive)
  // println(mary isAlive) // need to import feature flag to enable postfix notation apparently

  // practice code ------------------------------------------------------------------------------------------
  val ritviz = tom.unary_+
  val liggi = +mary
  println(ritviz.name + " is " + ritviz.age + " years old " )
  println(liggi.name + " is " + liggi.age + " years old ")

  println(ritviz.learns("singing"))
  println(liggi.learnsScala())
  println(ritviz learns "singing")
  // println(liggi learnsScala) // need to import feature flag to enable postfix notation apparently

  println(liggi.apply(4))

  /*
  1. Overload the + operator
     mary + "the rockstar" => new person "Mary (the rockstar)"

  2. Add age to Person class
     Add a unary + operator => new person with the age + 1
     +mary => mary with age incrementer

  3. Add a "learn" method in the Person class => "mary learn Scala"
     Add a learnsScala method, calls learns method with "Scala"
     Use it in postfix notation

  4. Overload the apply method
     mary.apply(2) => "Mary watched Inception 2 times"

  */

}
