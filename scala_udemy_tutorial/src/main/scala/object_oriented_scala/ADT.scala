package object_oriented_scala

object ADT extends App {

  // abstract
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("Woof hongry")
  }

  // TRAITS
  // traits don't have ctors
  // multiple traits may be inherited by the same class
  // choose trait when you want behaviour: about what the object should do
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    val creatureType: String = "Mr. Krok"
    def eat: Unit = "kronchy"
    def eat(animal: Animal): Unit = println(s"I am a ${this.creatureType} and I eat ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc eat dog
  croc.eat(dog)

}
