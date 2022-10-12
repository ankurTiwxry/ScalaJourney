package object_oriented_scala

// Scala offers SINGLE CLASS INHERITANCE => Can only extends one class at a time
// More intricate inheritance models using TRAITS
object InheritanceAndTraits extends App {

  abstract class Animal {
    // private def eat = println("nomnom")
    // the private method cannot be called by an extension of the class
    // protected will give access to this and subclasses

    val creatureType: String
    def eat: Unit
  }

//  class Cat extends Animal
//  val cat = new Cat
//  cat.eat

  // CONSTRUCTORS
//  class Person(name: String, age: Int)
  // ERROR: as JVM tries to call the CTOR of the parent first
  // class Adult(name: String, age: Int, idCard: String) extends Person
//  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // OVERRIDING: both function definitions and fields
  // Fields can be directly overridden in the CTOR itself
  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("Ik ben Potato")
  }

//  val dog = new Dog
//  dog.eat

  // TYPE substitution : POLYMORPHISM
  // OverRIDING  : supplying a different implementation in derived classes
  // OverLOADING : supplying multiple methods with different signatures but the same name and class

  // SUPER : to access stuff from the parent

  // preventing overrides
  // Keyword : FINAL : before class, functions def, field
  // Seal the class: prevent extension in other files: but works in this file : Used for exhaustive class lists



}
