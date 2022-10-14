package object_oriented_scala

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // Seemingly, we instantiated an abstract class!
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("HAHAHAHHAHAHAHA")
  }
  // The compiler basically creates a class here and instantiates it to the val => ANONYMOUS CLASS

  // This prints : class object_oriented_scala.AnonymousClasses$$anon$1
  // notice: ANON                                                ^^^^
//  println(funnyAnimal.getClass)

  /*

    Equivalent to:

    class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("HAHAHAHHAHAHAHA")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$anon$1

  */

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, and I am an instance of person")
  }
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, and I am an anonymous instance of person")
  }
//  jim.sayHi
//
//  val tim = new Person("Tim")
//  tim.sayHi

  // works for abstract and non-abstract data types

  // practice code ---------------------------------------------------------------------------------------

  /*
      1. Generic trait MyPredicate[-T] -> method test(T) => Boolean
      2. Generic trait MyTransformer[-A,B] -> methodTransform[A, B] with a method transform(A) => B
      3. MyList: methods
        - map(transformer) => MyList
        - filter(predicate) => MyList
        - flatMap(transformer from A to MyList[B]) => MyList[B]

      eg.
      1. class EvenPredicate extends MyPredicate[Int] will take an int and return whether it is even or not
      2. class StringToIntTransformer extends MyTransformer[String, Int]

      3.
        a. [1,2,3].map(n*2) = [2,4,6]
        b. [1,2,3,4].filter(n%2) = [2,4]
        c. [1,2,3].flatMap(n => [n,n+1]) => [1,2,2,3,3,4]

    */

  trait MyPredicate[-T] {
    def test(t: T): Boolean
  }

  trait MyTransformer[-A, B] {
    def transform(a: A): B
  }

//  class EvenPredicate extends MyPredicate[Int] {
//    def test(t: Int): Boolean =
//      if(t%2==0) true
//      else false
//  }

//  val even_predicate_test = new EvenPredicate
//  println(even_predicate_test.test(5))
//  println(even_predicate_test.test(6))

  val even_predicate_test = new MyPredicate[Int] {
    override def test(t: Int): Boolean = {
      if(t%2==0) true
      else false
    }
  }

//  val times_two_transform = new MyTransformer[Int, String] {
//    override def transform(t: Int): String = s"$t * 2 = ${t*2}"
//  }

  abstract class MyList[+T] {
    def head: T
    def tail: MyList[T]
    def isEmpty: Boolean
    def add[U >: T](element: U): MyList[U]

    def map[B](transformer: MyTransformer[T, B]): MyList[B]
//    def flatMap[B](transformer: MyTransformer[T, MyList[B]]): MyList[B]
    def filter(predicate: MyPredicate[T]): MyList[T]
  }

  object EmptyClass extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: MyList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = false
    def add[U >: Nothing](element: U): MyList[U] = new ConsClass(element, EmptyClass)

    def map[B](transformer: MyTransformer[Nothing, B]): MyList[B]  = EmptyClass
//    def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B]  = EmptyClass
    def filter(predicate: MyPredicate[Nothing]): MyList[Nothing]  = EmptyClass

  }

  class ConsClass[+T](h: T, t: MyList[T]) extends MyList[T] {
    def head: T = h
    def tail: MyList[T] = t
    def isEmpty: Boolean = false
    def add[U >: T](element: U): MyList[U] = new ConsClass(element, this)

    def map[B](transformer: MyTransformer[T, B]): MyList[B] = {
      new ConsClass(transformer.transform(h), t.map(transformer))
    }
//    def flatMap[B](transformer: MyTransformer[T, MyList[B]]): MyList[B]

    def filter(predicate: MyPredicate[T]): MyList[T] = {
      if (predicate.test(h)) new ConsClass(h,t.filter(predicate))
      else t.filter(predicate)
    }

  }

  val list_of_integers: MyList[Int] = new ConsClass(1, new ConsClass(2, new ConsClass(3, EmptyClass)))
  val list_of_strings: MyList[String] = new ConsClass("Holaa", new ConsClass("Hello", new ConsClass("Ciao", EmptyClass)))


  println(list_of_integers.map(new MyTransformer[Int, Int] {
    override def transform(t: Int): Int = t * 2
  }).toString)
  val filtered_list = list_of_integers.filter(even_predicate_test)

  println(filtered_list.toString)
}

// Too weird for now, will come back later