import scala.math._
import scala.collection.mutable.ArrayBuffer


object ScalaTutorial{
	def main(args : Array[String]){
		
		// map and filter
	  val log10func = log10 _
	  println(log10func(1000))
	  List(1000.0, 10000.0).map(log10func).foreach(println)
	  List(1,2,3,4).map((x: Int) => x*50).foreach(println)
	  List(1,2,3,4,5).filter(_ % 2 == 0).foreach(println)
	  

	}
}

