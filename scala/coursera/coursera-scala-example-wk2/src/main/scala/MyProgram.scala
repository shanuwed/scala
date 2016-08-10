//import java.math._
//import java.lang.Math._
import math.abs

/**
  * Created by suhan on 8/9/2016.
  */
object MyProgram {
  def main(args: Array[String]) = {
    println("**Currying")
    println("sum(1,10)=" + currying.sum(1, 10))
    println("sumCubes(1,2)=" + currying.sumCubes1(1, 2)) // expected value: 9
    println("fact(4)=" + currying.fact(4))
    println("sumFactorials(2)=" + currying.sumFactorials(1, 2))
    println("sumFactorials(3)=" + currying.sumFactorials(1, 3))

    println("\n**exercise_wk2")
    exercise_wk2.test()

    println("\n**Fixed point")
    fixed_point.test()
  }
}

// Session : Currying
object currying {
  def sum(a: Int, b: Int): Int= {
    if(a>b) 0
    else a + sum(a+1, b)
  }

  def cube1(x:Int):Int = x * x * x

  def sumCubes1(a: Int, b: Int): Int = {
    if(a>b) 0
    else cube1(a) + sumCubes(a+1, b)
  }

  // Summing with Higher-Order Functions
  // Let's define (in a more generalized format):
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if(a>b) 0
    else f(a) + sum(f, a+1, b)
  }

  // Then we can write:
  def sumInts(a:Int, b:Int) = sum(id, a,b)
  def sumCubes(a:Int, b:Int) = sum(cube, a,b)
  def sumFactorials(a:Int, b:Int) = sum(fact, a,b)

  // where
  def id(x:Int ):Int = x
  def cube(x:Int):Int = x * x * x
  def fact(x:Int):Int = if(x <= 1) 1 else x * fact(x-1)

  /// Function Types
  // The type A => B is the type of a fucntion that take san arguemn of type A and
  // returns a result of type
  // So Int => Int is the type of function that map integers to integers

  /// Anonymous Function
  // Example:
  // (x: Int) => x*x*x
  // Anonymous functions can alwyas be expressed using def as follows:
  // Given an an anonymous function: (x1:T1,... xn:Tn) => E can be
  // expressed using def as follows:
  // def f(x1:T1,... xn:Tn) = E; f
  // where f is an arbitrary, fresh name

  /// Summation with Anonymous Functions
  // Using anonymous functions, we can write in shorter way
  // def sumCubes(a:Int, b:Int) = sum(x => x*x*x, a,b)

  ///Currying
  // Functions Returning Functions
  // Let's rewrite sum as follows (as a function returing a function)
  // The returned function sumF applies the given function parameter f
  // and sums the results
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if(a>b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }
}

object exercise_wk2 {
  // write a product function
  def product(f: Int => Int)(a: Int, b:Int): Int =
    if(a > b) 1
    else f(a) * product(f)(a+1, b)

  // write factorial interm of product function
  def fact(n: Int) = product(x => x)(1,n)

  // write a function that can do either sum or product
  // in fact this is a map reduce function (in a way)
  def mapReduce(f:Int => Int, combine: (Int,Int)=>Int, zero: Int)(a: Int, b:Int ): Int =
  if(a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a+1, b))

  // now if you want to express product function in terms of mapReduce fucntion it would be like this:
  def product2(f:Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x,y) => x * y, 1)(a, b)

  def test() = {
    println("product( x=> x * x)(3,4)=" + product( x=> x * x)(3,4))
    println("fact(4)=" + fact(4))
    println("product2(x => x * x)(3, 4)=" + product2(x => x * x)(3, 4))
  }
}

// 8/10/2016
// Finding fixed points
object fixed_point{
  val tolerance = 0.0001
  def isCloseEnough(x: Double, y:Double) =
    abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      // println("guess = " + guess)
      val next = f(guess)
      if(isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  // First attempt
  // To calculate sqrt(x) by iteration towards a fixed point
  def sqrt(x: Double) = {
    fixedPoint(y => x/y)(1.0)
    // but this does not converage
  }

  def test(): Unit = {
    // f(x) = 1 + x/2; initial value = 1
    println("fixedPoint(x => 1 + x/2)(1)=" + fixedPoint(x => 1 + x/2)(1))
    // should return something close to 2

    println("sqrt(2) = " + sqrt(2))
  }
}

