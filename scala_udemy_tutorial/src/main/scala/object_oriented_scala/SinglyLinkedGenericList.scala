package object_oriented_scala

object ListTest extends App {

}

abstract class SinglyLinkedGenericList[+T] {
  def head: T
  def tail: SinglyLinkedGenericList[T]
  def isEmpty: Boolean
  def add[U >: T](element: U): SinglyLinkedGenericList[U]
}

object EmptyClass extends SinglyLinkedGenericList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: SinglyLinkedGenericList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean= false
  def add[U >: Nothing](element: U): SinglyLinkedGenericList[U] = new ConsClass(element, EmptyClass)
}

class ConsClass[+T](h: T, t: SinglyLinkedGenericList[T]) extends SinglyLinkedGenericList[T] {
  def head: T = h
  def tail: SinglyLinkedGenericList[T] = t
  def isEmpty: Boolean = false
  def add[U >: T](element: U): SinglyLinkedGenericList[U] = new ConsClass(element, this)
}