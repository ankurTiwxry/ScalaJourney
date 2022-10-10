package object_oriented_scala

object Objects extends App{

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  // instead, it has OBJECTS => static like functionality

  object Person {
    // "STATIC/CLASS level functionality"
    val N_EYES = 2
    def canFly: Boolean = false

    def apply(mother: Person, father: Person): Person = new Person("baby")


  }

  // Objects and classes often have the same name
  // Often in the same file or the same scope
  class Person(val name: String) {
  // "INSTANCE level functionality"
  }

  // this particular case of class and object are called COMPANIONS => reside in the same scope with the same name

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object: Singleton class
  val mary = new Person("Mary")
  val john = new Person("John")
  println (mary == john)

  // often we have factory methods in singleton objects
  val new_baby = Person.apply(mary, john)
  val another_new_baby = Person(mary, john)

  // SCALA APPLICATIONS
  // only a scala object with
  //  def main(args: array[String]): Unit
  // ^ can define code inside here instead of extends App

}
