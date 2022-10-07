package lecture_one_basics

object CallByNameVsValue extends App {

  def CallByValue(x: Long): Unit = {
    println("by value: " + x )
    println("by value: " + x )
  }

  def CallByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  // Evaluated once
  CallByValue(System.nanoTime())
  // Evaluated each time
  CallByName(System.nanoTime())

}
