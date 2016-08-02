// Test callback functions

object MyTest {
	def oncePerSecond(callback: () => Unit){
		while(true){
			callback();
			Thread.sleep(1000); // Or just Thread sleep 1000
		}
	}
	
	def timeFlies(){
		println("time flies like an arrow..")
	}
	
	// callback is a function that takes an Int
	def oncePerSecond2( callback: Int => Unit ){
		// val counter = 0; // this would not work because val is immutable
		var counter = 0;
		while(true){ 
			callback(counter);
			Thread sleep 1000;
			counter+=1
		}
	}
	
	def timeFlies2(arg : Int){
		println("timeFlies2:"+arg);
	}
	
	def main(args : Array[String]){
		//oncePerSecond(timeFlies);
		// or using an anonymous function
		//oncePerSecond(() => println("time flies!"));
		
		oncePerSecond2(timeFlies2);
	}
	

}
