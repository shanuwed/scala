import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter // print to a file
import scala.io.Source // read from a file

object ScalaTutorial{
	def main(args : Array[String]){
		var multTable = Array.ofDim[Int](10,5)
		
		for(i <- 0 to 9){
			for(j <- 0 to 4){
				multTable(i)(j) = i * j
			}
		}
		
		for(i <- 0 to 9){
			for(j <- 0 to 4){
				printf("%d : %d = %d\n", i, j, multTable(i)(j))
			}
		}
		
		var names = ArrayBuffer[String]()
		names.insert(0, "Hal")
		names += "Mark"
		names ++= Array("Sue", "Joe")
		names.foreach(println)
		println("remove two items starting at index 1")
		names.remove(1, 2) // at index 1 two items
		var name = " "
		for(name <- names){
			println(name)
		}
		
		val favNums = new Array[Int](12) // of size 12
		for(j <- 0 until favNums.length)
			favNums(j) = j
		val favNums2 = for(num <- favNums) yield 2 * num
		favNums2.foreach(println)
		
		println("Find multiple of 4")
		var favNums4 = for(num <- favNums2 if num % 4 == 0) yield num
		favNums4.foreach(println)
		
		println("SORT")
		val sortedNums = favNums.sortWith(_ > _) // DESC
		sortedNums.foreach(println)
		
		println("separated with commas")
		println(sortedNums.deep.mkString(", "))

	}
}

