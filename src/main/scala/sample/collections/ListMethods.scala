package sample.collections

object ListMethods extends App {
  val fruit: List[String] = List("apples", "oranges", "pears")
  val nums = List(1, 2, 3, 4)
  val diag3: List[List[Int]] = {
    List(
      List(1, 0, 0),
      List(0, 1, 0),
      List(0, 0, 1)
    )
  }
  val empty: List[Nothing] = List()
  //val empty  = Nil
  val xs: List[String] = List()
  
  //consturctor
  val fruits = "apples" :: ("orange" :: ("pear" :: Nil))
  val num = 1 :: 2 :: 3 :: 4 :: Nil

  def isSort(xs: List[Int]): List[Int] = if (xs.isEmpty) Nil  else insert(xs.head, xs.tail)
  private def insert(s: Int, xs: List[Int]): List[Int] = {
    if (xs.isEmpty || s <= xs.head) 
      s :: xs
    else xs.head :: insert(s, xs.tail)
  }
}
