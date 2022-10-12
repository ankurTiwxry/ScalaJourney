package object_oriented_scala

object Generics extends App {

  // generic CLASSES
  class MyList[+A] {
    // use the type A inside the class definition
    def add[B >: A](element: B): MyList[B] = ???
    /*
    SOLUTION TO HARD QUESTION -------------------------------------------------------------------------
      A = Cat <: Animal
      B = Dog <: Animal
      If I add B to a list of A, then the entire list will now become a list of Animals
    */
  }

  // can also work for traits and multiple data types
  // trait MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

//  // generic METHODS
//  object MyList {
//    def empty[A]: MyList[A] = ???
//  }
//
//  val emptyListOfIntegers = MyList.empty[Int]

  // VARIANCE PROBLEM with 3 cases
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // CASES // OPTIONS
  // 1. yes, List[Cat] extends List[Animal] -> CO-VARIANT LIST
  class CovariantList[+A]

  // Usage
  val animal: Animal = new Cat // just like we did this earlier
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // what if I do animalList.add(new Dog) is this okay ??? HARD QUESTION ??? ---------------

  // 2. no, list of cats and animals are separate things -> INVARIANT LIST
  class InvariantList[A]
  // val invariantList[Animal] = new InvariantList[Cat] -> NOT ALLOWED

  // 3. hell no! -> CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
  // this relation doesn't make sense for a list
  // but what if we talk about some other property: the TRAINER of cats
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]
  // Now it makes more sense


  // BOUNDED TYPES : lets you use your generic classes only for certain types that are either subclass or superclass
  // upper bounded type
  class Cage[A <: Animal](animal: A)
    // CAGE only accepts A (subtypes of Animal)

  val cage = new Cage(new Dog)

  // bounded types solve a covariance issue
  // Changed MyList[A] to MyList[+A]
  // we can't write methods in it some covariant contravariant issue
  // NOW WE ANSWER THE HARD QUESTION
  // Adding a dog to a list of cats with make the entire list more generic


}
