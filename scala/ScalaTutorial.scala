import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter // print to a file
import scala.io.Source // read from a file

object ScalaTutorial{
	def main(args : Array[String]){
		var numberGuess = 0
		
		do {
			print("Guess a number ");
			numberGuess = readLine.toInt
		} while(numberGuess != 14)
		printf("Secrete Number is %d\n", 14)
	}
}

