object Main extends App {
  println("Hello")
}


object intsets {
  val t1 = new NonEmpty(3, new Empty, new Empty)
  val t2 = t1.incl(4)
  t1.toString() // t1: NonEmpty = {.3.}
  t2.toString   // t2: IntSet = {.3{.4.}}

  val t6 = new NonEmpty(6, new Empty, new Empty)
  val t8 = t6.incl(8)

  val t9 = t2.union(t6)
  println(t9.toString)

  t1.contains(3)
  t1.contains(4)
  t1.contains(5)

  (new NonEmpty(7, new Empty, new Empty)).contains(7)
}


// Abstract class can contain members without
// implementation
abstract class IntSet {
  def incl(x : Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  def contains(x: Int): Boolean = {
    if(x == elem) true
    else if(x < elem ) left.contains(x)
    else right.contains(x)
  }

  // weird implementation because we want it immutable
  def incl(x: Int): IntSet = {
    if(x < elem) new NonEmpty(elem, left.incl(x), right)
    else if (x > elem) new NonEmpty(elem, left, right.incl(x))
    else this // element is already contained the
  }

  def union(other: IntSet): IntSet = {
    // this is fking tricky!
    left.union(right).union(other).incl(elem)
  }

  override def toString = "{" + left + elem + right + "}"
}

class Empty extends IntSet{
  def contains(x: Int): Boolean = false
  def incl(x : Int): IntSet = {
    new NonEmpty(x, new Empty, new Empty)
  }

  def union(other: IntSet): IntSet = {
    other
  }

  override def toString = "."
}


// demo override
object overrides {
  println("hello")
}

abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo = 2
  def bar = 3 // not required
}