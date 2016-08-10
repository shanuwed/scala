/* ReadFiles.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object ReadFiles {
	def main(args: Array[String]) {
		val logFile = "/home/sujin/scala-src/data/*.d"
		val conf = new SparkConf().setAppName("Read Files")
		val sc = new SparkContext(conf)
		val logData = sc.textFile(logFile, 2).cache()
		val numAs = logData.filter(line => line.contains("sea")).count()
		val numBs = logData.filter(line => line.contains("ship")).count()
		println("lines with sea: %s, Lines with ship: %s".format(numAs, numBs))
	}
}

