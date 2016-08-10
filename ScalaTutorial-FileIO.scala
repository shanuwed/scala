import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source


object ScalaTutorial{
	def main(args : Array[String]){
		
		// to write to a file
		val fw = new PrintWriter("test.txt")
		fw.write("some random text\nNext line")
		fw.close()
		
		// to read a file
		val textFromFile = Source.fromFile("test.txt", "UTF-8")
		val lineIter = textFromFile.getLines
		for(line <- lineIter)
			println(line)
		textFromFile.close()
		
	}
}

