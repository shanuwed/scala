import scala.math._
import scala.collection.mutable.ArrayBuffer


object ScalaTutorial{
	def main(args : Array[String]){
		
		// create a tuple
		var tupleMarge = (103, "marge simpson", 10.25)
		
		printf("%s owes us %.2f\n", tupleMarge._2, tupleMarge._3)
		
		// to iterate tuple
		tupleMarge.productIterator.foreach{ i => println(i)} // print all out 
		// in separate line
		
		// convert tuple to a string
		println(tupleMarge.toString())

	}
}

