import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter // print to a file
import scala.io.Source // read from a file

object ScalaTutorial{
	def main(args : Array[String]){
		
		// define a function 9that returns an int
		def add(a : Int = 1, b : Int = 1) : Int = {
			return a + b
		}
		
		// define a procedure (no return value)
		def sayHi() : Unit = {
			println("Hi") 
		}
		
		// a function that takes a  variable number of arguments
		def getSum(args : Int*) : Int = {
			var sum = 0
			for(i <- args){
				sum += i
			}
			// return
			sum
		}
		
		println(add(5,6))
		
		println( add(b=6, a=5))
		
		sayHi
		
		println(getSum(1,2,3,4,5,6,7,8,9,10))
		

	}
}

