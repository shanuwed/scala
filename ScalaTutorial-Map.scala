import scala.math._
import scala.collection.mutable.ArrayBuffer


object ScalaTutorial{
	def main(args : Array[String]){
		
		// Map is a key value pairs
		// Immutable...
		val employees = Map("Manager" -> "Bob Smith", 
			"Secretary" -> "James Brown")
		
		if(employees.contains("Manager"))
			printf("Manager : %s\n", employees("Manager"))
			
		// Mutable map
		val customers = collection.mutable.Map(100 -> "paul smith",
			101 -> "ally smith")
		
		printf("Cust 1 : %s\n", customers(100))
		
		customers(100) = "Tom Marks"
		customers(102) = "Megan swift"

		// cycle through the map
		for((k,v) <- customers)
			printf("%d <- %s\n", k, v);
	}
}

