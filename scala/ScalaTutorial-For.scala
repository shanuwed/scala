

object MyProgram {
  def main(args: Array[String]): Unit = {
    println("Hello world")
    test1()
    test2()
    test3()
    test4
  }
  
  def test1(){
    var i = 0
    var evenList  = for { i <- 1 to 12
      if(i % 2) == 0
      } yield i
    
    for(i <- evenList)
      println(i)
  }
  
  def test2(){
    for(i <- 1 to 5)
      println(i)
  }
  
  def test3(){
    var i=0
    for(i<- 1 to 5; j <- 6 to 8){
      println("i:" + i + " j:" + j)
    }
  }
  
  def test4() {
    val list = List(1,2,3,5,7)
    for(i <- list){
      if(i == 5)
        return // simulate break
        
      if(i != 1)
        println(i)
    }
  }
}
