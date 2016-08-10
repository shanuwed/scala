import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter // print to a file
import scala.io.Source // read from a file

object ScalaTutorial{
	def main(args : Array[String]){
		
		val name = "Su"
		val age = 39
		val weight = 180
		
		println(s"Hello $name")
		println(f"I am ${age +1} and weigh $weight%.2f")
		
		// %c for characters
		// %d for integers
		// %f for floating points
		// %s for strings
		
		printf("'%.5f'\n", 3.14) // floating points with 5 positions
		
		printf("'%-5s'\n", "hi") // right justified
		
		// String
		var randSent = "I saw a dragon fly by"
		
		println(randSent.concat(" yesterday"))
		println("dragon index starts at " + randSent.indexOf("dragon"))
		println("Letter at position 3 is " + randSent(3))
		
		// convert a string to an array
		var a = randSent.toArray
		for( i <- 0 until a.length){
			println(a(i))
		}
	}
}

