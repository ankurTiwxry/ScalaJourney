package object_oriented_scala

import java.util

// Singly linked list to hold integers
/*
  Methods ---------------------
  head -> first element of list
  tail -> remainder of the list
  isEmpty -> is the list empty
  add(int) -> new list with this element added
  toString -> a string representation of the list
*/
object linkedListTest extends App {
  val l = new Cons(1, Empty)
  print(l.head())
}

abstract class MyList {

  // methods
  def head(): Int
  def tail(): MyList
  def isEmpty(): Boolean
  def add(element: Int): MyList
  def printElements: String
  override def toString(): String = "[" + printElements + "]"

}

object Empty extends MyList {
  def head(): Int = throw new NoSuchElementException
  def tail(): MyList = throw new NoSuchElementException
  def isEmpty(): Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)
  def printElements: String = ""

}

class Cons(h: Int, t: MyList) extends MyList {
  def head(): Int = h
  def tail(): MyList = t
  def isEmpty(): Boolean = false
  def add(element: Int): MyList = new Cons(element, this)
  def printElements: String =
    if(t.isEmpty()) "" + h
    else h + " " + t.printElements
}
