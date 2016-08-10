package funsets

object Main extends App {
  import FunSets._

  println(contains(singletonSet(1), 1))

  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s3 = singletonSet(3)

  val s = union(s1, s2)
  println("Union 1: " + contains(s, 1))
  println("Union 2: " + contains(s, 2))
  println("Union 3: " + !contains(s, 3))

}
