import scala.math._
import scala.collection.mutable.ArrayBuffer


object ScalaTutorial{
	def main(args : Array[String]){
		
		val rover = new Animal
		rover.setName("Rover")
		rover.setSound("Woof")
		printf("%s says %s\n", rover.getName, rover.getSound)
		
		val whiskers = new Animal("Whiskers", "Meow")
		println(s"${whiskers.getName} with id ${whiskers.id} says ${whiskers.getSound}")
		
		println(whiskers.toString)
		
		val fang = new Wolf("fang")
		fang.moveSpeed = 36.0
		println(fang.move)
		
	}
	
	abstract class Mammal(val name: String){
	  var moveSpeed: Double // abstract field
	  def move: String // abstract method (no body)
	}
	
	class Wolf(name: String) extends Mammal(name){
	  var moveSpeed = 35.0
	  def move = "The wolf %s runs %.2f mph".format(this.name, this.moveSpeed)
	}
	
	class Animal(var name: String, var sound: String){
		this.setName(name)
		
		// there's no static variable, but ...
		val id = Animal.newIdNum
		
		def getName(): String = name //returns name
		def getSound(): String = sound // returns sound
		
		def setName(name: String){
		  if(!(name.matches(".*\\d+.*")))
		    this.name = name
		  else
		    this.name = "No name"
		}
		
		def setSound(sound: String){
		  this.sound = sound
		}
		
		// create other constructors
		def this(name: String) {
		  this(name, "No Sound")
		  this.setName(name)
		}
		
		def this(){
		  this("No name","No Sound")
		}
		
		override def toString(): String = {
		  return "%s with id %d says %s".format(
		      this.name,
		      id,
		      sound)
		}
	}
	
	object Animal {
	  private var idNumber = 0
	  private def newIdNum = {idNumber += 1; idNumber}
	}
}

