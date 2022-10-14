package object_oriented_scala

object CaseClasses extends App {
  /*
    We need to re-implement alot of boilerplate
    eg. equals, hashCode, toString
  */

  case class Person(name: String, age: Int)

  // 1. Class parameters are promoted to fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim) // println(instance) = println(instance.toString)
  println(jim.toString)

  // 3. Equals and hashCode are implemented OOTB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. Handy copy methods
  val jim3 = jim.copy()
  println(jim3)
  val jim4 = jim.copy(age=23)
  println(jim4)

  // 5. Case classes have companion objects
  val thePerson = Person
  println(thePerson)
  val mary = Person("Mary", 28)
  println(mary)
  // in practice we don't use the keyword NEW when instantiating a case class

  // 6. Case classes are serializable => makes them very useful with distributed systems
  // eg. Akka framework => uses serializable messages ove the network, the messages in general are case classes

  // 7. Case classes have extractor patterns => They can be used in PATTERN MATCHING

  // 8. Case objects => they act like case classes but are objects
  case object UnitedKingdom {
    def name: String = "Oops"
  }
  // this will behave exactly like a case class but won't have a companion object (point 5)

}

// PRACTICE TEST
/*
  Expand MyList - use case classes and case objects
*/
