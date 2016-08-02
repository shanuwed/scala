import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer


object ScalaTutorial {
	def main(args : Array[String]) {
	
		def factorial(num: BigInt) : BigInt = {
			if(num == 1)
				return num
			else
				return num * factorial(num-1)
		}
		
		println("Factorial of 4 = " + factorial(4))
		
		
		val friends = Array("Bob", "Tom")
		
		friends(0) = "Sue"
		
		println("Best friends " + friends(0))
		
		val friends2 = ArrayBuffer[String]()
		
		friends2.insert(0, "Phil")
		
		friends2 += "Mark"
		
		friends2 ++= Array("Susy", "Paul")
		
		friends2.insert(1, "Mike", "Sally", "Sam", "Mary", "Sue")
		
		friends2.remove(1,2) // remove the item at index 1. How many? = 2
		
		var friend : String = " "
		for(friend <- friends2)
			println(friend)
			
		//*******************8
		// Whenever the size of the array is fixed use Array
		var nums = new Array[Int](20)
		
		// assign number
		for(i <- 0 until nums.length)
			nums(i) = i 
			
		nums.foreach(println)
		
		var nums2 = for(i <- nums) yield 2 * i
		for(j <- nums2)
			printf("%d ", j)
	
	}
}
