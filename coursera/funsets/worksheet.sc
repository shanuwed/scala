def product(f:Int => Int): (Int, Int)=>Int = {
  def p(a:Int, b:Int): Int = {
    if(a>b) 1
    else f(a) * p(a+1, b)
  }
  p
}

val r1 = product(x=>x)(1, 4)

def factorial(a: Int): Int = {
  product(x=>x)(1, a)
}

factorial(4)


// define sum function
def sum(f: Int => Int): (Int, Int)=>Int = {
  def p(a:Int, b: Int) : Int = {
    if(a>b) 0
    else f(a) + p(a+1, b)
  }
  p
}

val r2 = sum(x=>x)(1, 10)

// more generalized function of two
def uber(f:Int => Int):(Int, Int, Int, (Int, Int)=>Int ) => Int = {
  def p(a:Int, b:Int, zero: Int, op: (Int, Int)=>Int): Int = {
    if(a > b) zero
    else op(f(a), p(a+1, b, zero, op))
  }
  p
}

val r3 = uber(x=>x)(1, 10, 0, (x, y)=>(x+y)) // sum 1 to 10

val r4 = uber(x=>x)(1, 4, 1, (x, y) => (x * y)) // product 1 to 4