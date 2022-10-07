package object_oriented_scala

object OOBasics extends App{

  // Practice code 1
  // Wielder wrote Humanitarian Knowledge
  val writer1 = new Writer("Wielder", "Tibidabo", 1972)

  val novel1 = new Novel("Humanitarian Knowledge", 2020, writer1)
  println( novel1.getNovelName() + " was written by " + novel1.getAuthorsName() + " when he was " + novel1.getAuthorsAgeAtPublication() + " years old")

  val novel1_copy = novel1.getNewCopy(2025)
  println(novel1_copy.getYearOfRelease())

  // Practice code 2
  val ctr1 = new Counter(10)
  val ctr2 = ctr1.incrementCount(12)
  val ctr3 = ctr1.decrementCount()

  println(ctr1.getCurrentCount())
  println(ctr2.getCurrentCount())
  println(ctr3.getCurrentCount())
}

// example class -------------------------------------------------------------------------------------
// ctor
class Person(name: String, val age: Int) {
  // age here is a class parameter, NOT an accessible object
  // ADD val in front of a parameter to make it accessible

  // body: All lines of code will be executed on calling CTOR

  // val: definitions are FIELDS
  val x = 2
  println(1+5)

  // methods

  // method overLoad
  def greet(): Unit = println("Just Hi...")
  def greet(name: String): Unit = println(s"$name says \"Hi, $name\"!")
  def greetSmarter(name: String): Unit = println(s"${this.name}Express says \"Hi, $name\"!")

  // ctor overload: Better to use default values in ctor defn
  def this(name: String) = this(name, 0)
  def this() = this("Hola")

}

// practice code -------------------------------------------------------------------------------------

// 1.
// Novel and Writer Classes
// Writer: F(first_name, surname, year); M(getFullName())
// Novel: F(name, year_of_release, author); M(getAuthorAgeAtPublication(year_of_release), getAuthor(),
// getNewCopy(new_year_of_release): new instance of Novel)

class Writer(first_name: String, last_name: String, year_of_birth: Int) {
  def getFullName(): String = {
    first_name + " " + last_name
  }
  def getYearOfBirth(): Int = {
    year_of_birth
  }
}

class Novel(name: String, year_of_release: Int, author: Writer) {

  // functions
  def getNovelName(): String = {
    this.name
  }
  def getYearOfRelease(): Int = {
    this.year_of_release
  }
  def getAuthorsName(): String = {
    author.getFullName()
  }
  def getAuthorsAgeAtPublication(): Int = {
    year_of_release - author.getYearOfBirth()
  }
  def getNewCopy(new_release_year: Int): Novel = {
    new Novel(this.name, year_of_release = new_release_year, this.author)
  }
}

// 2.
// Counter Class(Int)
// M getCurrentCount(), incrementCount & decrementCount => new Counter() with overload to accept value
//

class Counter(count: Int) {
  // methods
  def getCurrentCount(): Int = {
    this.count
  }
  def incrementCount(value: Int = 1): Counter = {
    new Counter(this.count+value)
  }
  def decrementCount(value: Int = 1): Counter = {
    new Counter(this.count-value)
  }
}
