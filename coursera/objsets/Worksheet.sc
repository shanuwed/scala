val succ = (x:Int) => x+1

val anonfun1 = new Function1[Int, Double] {
  def apply(x:Int) = x + 1.1
}

succ(1)
anonfun1(1)

val fun2 = (x:Int) => Int
def fun3(x:Int) = x+3
val fun4 = new Function1[Int, Int] {
  def apply(x:Int) = x + 1
}

trait Expr {
  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
}

class Number(n:Int)extends Expr{
  def isNumber: Boolean = true
  def isSum: Boolean = false
  def numValue: Int = n
  def leftOp: Expr = throw new Error("Number.leftOp")
  def rightOp: Expr = throw new Error("Number.rightOp")
}


class Sum(e1:Expr, e2:Expr) extends Expr {
  def isNumber: Boolean = false
  def isSum: Boolean = true
  def numValue: Int = throw new Error("Sum.numValue")
  def leftOp: Expr = e1
  def rightOp: Expr = e2
}

def eval(e: Expr) : Int = {
  if(e.isNumber) e.numValue
  else if(e.isSum) eval(e.leftOp) + eval(e.rightOp)
  else throw new Error("Unknown expression" + e)
}

// Writing classificaiton and access function becomes

// Type TEst and Type cast
// def isInstanceOf[T]: Boolean
// def asInstanceOf[T]: T

// Scala              Java
//x.isInstanceOf[T]     x instanceof T
//x.asInstanceOf[T]     (T) x

//