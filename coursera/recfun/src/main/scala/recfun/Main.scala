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

    var count = countChange(4,List(1,2))
    println("Expected: 3 Final count = " + count)

    count = countChange(300,List(5,10,20,50,100,200,500))
    println("Expected: 1022 Final count = " + count)

    count = countChange(301,List(5,10,20,50,100,200,500))
    println("Expected: 0 Final count = " + count)

    count = countChange(300,List(500,5,50,100,20,200,10))
    println("Expected: 1022 Final count = " + count)

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
      val stack = new mutable.Stack[Char]()
      for(c <- chars){
        if(c == '(')
          stack.push('(')
        else if(c == ')') {
          if(stack.isEmpty)
            return false
          val p = stack.pop()
          if(p != '(')
            return false
        }
        // else - don't care
      }

      // If stack is emtpty (nothing left because every pair matched) then return true
      return stack.isEmpty
    }

    def balance2(chars: List[Char]): Boolean = {
      val stack = new mutable.Stack[Char]()

      def loop(stack: mutable.Stack[Char], list: List[Char]): Boolean = {
        if(list.isEmpty) stack.isEmpty
        else{
          if(list.head == '(') {
            stack.push('(')
          }
          else if(list.head == ')'){
            if(stack.isEmpty)
              return false
            if(stack.pop() != '(')
              return false
          }
          loop(stack, list.tail)
        }
      }
      loop(stack, chars)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coinsIn: List[Int]): Int = {
      var count = 0
      if(coinsIn.isEmpty) 0

      val coins = coinsIn.sorted

      def loop(money: Int, coins: List[Int]): Unit = {
        //printf("money=%d coins:%s\n", money, coins.toString())
        if(coins.isEmpty){
          //println("coins empty")
          return
        }

        val remainder = money - coins.head
        if(remainder == 0) {
          //println("  remainder == 0 (INCREMENT)")
          count += 1
          loop(money, coins.tail)
        }
        else if(remainder > 0) {
          //println("  remainder > 0")
          loop(remainder, coins)
        }
        else {
          //println("  remainder < 0")
          loop(money, coins.tail)
        }

        loop(money, coins.tail)
      }

      loop(money, coins)
      count
    }
  }
