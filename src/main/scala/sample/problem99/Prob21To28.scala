package sample.problem99

object Prob21To28 extends App{
  /*
   * P21 (*) Insert an element at a given position into a list.
   Example:
   scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
   res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
   */
  def insertAt[T](symbol: T, position: Int, list:List[T]): List[T] = {
    list.take(position) ::: (symbol :: list.drop(position))
  }
  
  def insertAt2[T](symbol: T, position: Int, list:List[T]): List[T] = list.splitAt(position) match {
    case (pre, post) => pre ::: symbol :: post
  }
  
//  println(insertAt('new,2, List('a, 'b, 'c, 'd)))
//  println(insertAt2('new,-2, List('a, 'b, 'c, 'd)))
  /*
   * P22 (*) Create a list containing all integers within a given range.
   Example:
   scala> range(4, 9)
   res0: List[Int] = List(4, 5, 6, 7, 8, 9)
   */
  def rangeFuncionly(start: Int, end: Int): List[Int] = {
    List.range(start, end+1)
  }
  def rangeRecursive(s: Int, e: Int): List[Int] = {
    if(e < s) Nil
    else
      s :: rangeRecursive(s + 1, e)
  }
 
  def rangeTailRecurisive(s: Int, end: Int): List[Int] ={
    def rangeR(end: Int, result: List[Int]): List[Int] = {
      if(end < s) result
      else
        rangeR(end -1, end :: result)
    }
    rangeR(end, Nil)
  }
  
  def unfoldRight[A, B](s: B)(f: B => Option[(A, B)]): List[A] =
    f(s) match {
      case None         => Nil
      case Some((r, n)) => r :: unfoldRight(n)(f)
    }
  def rangeFunctional(start: Int, end: Int): List[Int] =
    unfoldRight(start) { n =>
      if (n > end) None
      else Some((n, n + 1))
    }
  
//  println(rangeFuncionly(4, 9))
//  println(rangeRecursive(4, 9))
//  println(rangeTailRecurisive(4, 9))
//  println(rangeFunctional(4, 9))
  
  
  /*
   * P23 (**) Extract a given number of randomly selected elements from a list.
   Example:
   scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
   res0: List[Symbol] = List('e, 'd, 'a)
   */
   
  def randomSelect[T](n: Int, ls: List[T]): List[T] = {
    import scala.util.Random._
    if(n <= 0) Nil
    else{
      val (rest, elem) = Prob11To20.removeAt(nextInt(ls.length), ls)
      elem :: randomSelect(n-1, rest)
    }
  } 
  
//  println(randomSelect(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g)))
  
  /*
   * P24 (*) Lotto: Draw N different random numbers from the set 1..M.
    Example:
    scala> lotto(6, 49)
    res0: List[Int] = List(23, 1, 17, 33, 21, 37)
   */
  
  def lotto(count: Int, max: Int): List[Int] ={
    randomSelect(count, List.range(1, max))
  }
  println(lotto(6, 49))
  
}
