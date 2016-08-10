import scala.math._
import scala.collection.mutable.ArrayBuffer


object ScalaTutorial{
	def main(args : Array[String]){
		
		val superboy = new Superhero("Superboy")
		println(superboy.fly)
		println(superboy.hitByBullet)
		println(superboy.ricochet(2500))
		
	}
	
	trait Flyable {
	  def fly: String
	}
	
	trait BulletProof{
	  def hitByBullet: String
	  def ricochet(startSpeed: Double): String = {
	    "This bullet ricochets at a speed of %.1f ft/sec".format(.5 *  startSpeed)
	  }
	}
	
	class Superhero(val name: String) extends Flyable with BulletProof{
	  def fly = "%s flys through the air".format(this.name)
	  def hitByBullet: String = "The bullet bounces off of %s".format(this.name)
	}
}

