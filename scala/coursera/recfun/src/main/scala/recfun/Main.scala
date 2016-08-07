package recfun

import scala.collection.mutable

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
    if(c==0) 1
    else if(c == r) 1
    else pascal(c-1, r-1) + pascal(c, r-1)
  }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      var stack = new mutable.Stack[Char]()
      for(c <- chars){
        if(c == '(')
          stack.push('(')
        else if(c == ')') {
          if(stack.isEmpty)
            return false
          var p = stack.pop()
          if(p != '(')
            return false
        }
        // else - don't care
      }

      // If stack is emtpty (nothing left because every pair matched) then return true
      return stack.isEmpty
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      0
  }
  }
