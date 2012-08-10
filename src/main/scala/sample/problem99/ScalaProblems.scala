package sample.problem99

object ScalaProblems extends App{
  val lastIndex = last(List(12,232,4343,4))
  val penultimateIndex = penultimate(List())
//  println(lastIndex)
//  println(penultimateIndex)
//  println( ListDemo.reversess(List(1,2,3,4,5)))
//  println(ListDemo.isPalindrome(List(1,2,3,2,1,3)))
//  println(gcdLoop(6, 24))
//  println(gcd(6, 24))
// print(penultimate2(List(1,2)))
//  print(nthOfList1(-1, List(1)))
  // println(reverseRecursive2(List(1,2,3,4,5,6,7)))
  // println(flatten2(List(1,2,List(11,22),3,List(33,List(333,List(444))))))
  print(compress1(List("2","2","3")))
  
  
  /*
   P01 Find the last element of a list  
   */
  def last[A](list: List[A]): A = list.last
  // recursive
  def last2[A](list: List[A]): A = list match{
    case h :: Nil  => h 
    case _ :: tail => last2(tail)
    case _         => throw new NoSuchElementException
  }

  /*
   P02 Find the last but one element of a list
   */
  def penultimate(list: List[String]): String = {
    if(list.isEmpty)
      null
    else if(list.length < 3)
      list.head
    else
      list(list.length-2)
  }
  // invoke the List methods
  def penultimate2[A](list: List[A]): A = {
    if(list.isEmpty) throw new NoSuchElementException
    else list.init.last
  }
  // pattern match  and recursive
  def penultimate3[A](list: List[A]): A = list match {
    case h :: _ :: Nil => h
    case _ :: tail      => penultimate3(tail)
    case _              => throw new NoSuchElementException
  }
  
  // Just for fun, let's look at making a generic lastNth function.

  // An obvious modification of the builtin solution works.
  def lastNthBuiltin[A](n: Int, ls: List[A]): A = {
    if (n <= 0) throw new IllegalArgumentException
    if (ls.length < n) throw new NoSuchElementException
    ls.takeRight(n).head
  }

  // Here's one approach to a non-builtin solution.
  def lastNthRecursive[A](n: Int, ls: List[A]): A = {
    def lastNthR(count: Int, resultList: List[A], curList: List[A]): A =
      curList match {
        case Nil if count > 0 => throw new NoSuchElementException
        case Nil              => resultList.head
        case _ :: tail        =>
          lastNthR(count - 1,
                   if (count > 0) resultList else resultList.tail,
                   tail)
      }
    if (n <= 0) throw new IllegalArgumentException
    else lastNthR(n, ls, ls)
  }
  /**
   P03  Find the Kth element of a list.
   */
  def nthOfList[A](n: Int, list: List[A]): A = {
    if(list.isEmpty || n < 0 || n > list.length) 
      throw new NoSuchElementException
    else 
      list(n)
  }
  def nthOfList1[A](n: Int, list: List[A]): A = (n, list) match {
    case(0, h :: _ )   => h
    case(n, _ :: tail) => nthOfList1(n-1, tail)
    case (_, Nil)      => throw new NoSuchElementException
  }
  /*
   P05 Reverse a list.
   */
  def reverse01(prefix: List[Int]): List[Int] = {
    var these = List[Int]()
    var pre = prefix
    while(!pre.isEmpty){
      these = pre.head :: these
      pre = pre.tail
    }
    these 
  }
  def reverse01_1[B](prefix: List[B]): List[B] = {
    var these = List[B]()
    var pre = prefix
    while(!pre.isEmpty){
      these = pre.head :: these
      pre = pre.tail
    }
    these 
  }
  def reverse02(prefix: List[Int]): List[Int] = prefix.reverse
  def reverseRecursive[A](ls: List[A]): List[A] = ls match {
    case Nil       => Nil
    case h :: tail => reverseRecursive(tail) ::: List(h)
  }
  //  tail recursive
  def reverseRecursive2[A](ls: List[A]): List[A] = {
    def reverseR(result: List[A], curList: List[A]): List[A] = curList match{
      case Nil       => result
      case h :: tail => reverseR(h :: result, tail)
    }
    reverseR(Nil, ls)
  }
  def reverseFunctional[A](ls: List[A]): List[A] =
    ls.foldLeft(List[A]()) { (r, h) => h :: r }

  /*
   P06  Find out whether a list is a palindrome. 
   */
  def isPalindrome(list: List[Int]): Boolean = {
    if(list.isEmpty)
      false
    else{
      val reList = reverse01(list)
      list == reList
    }
  }
  /* 
   P07 Flatten a nested list structure.
   scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
   res0: List[Any] = List(1, 1, 2, 3, 5, 8)
   */
  private def flatten(list: List[Any]): List[Any] = list flatMap {
    case ms: List[_] => flatten(ms)
    case e  => List(e)
  }
  def flatten2(ls: List[Any]): List[Any] = ls match {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }
  /*
   P08 Eliminate consecutive duplicates of list elements.
   If a list contains repeated elements they should be replaced
   with a single copy of the element. The order of the elements 
   should not be changed. 
   compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e) 
   */
  def compress[A](list: List[A]): List[A] = list match{
    case Nil => Nil
    case repeat :: tail => repeat :: compress(tail.dropWhile(_ == repeat))
  }
  // tail recursive
  def compress1[A](list: List[A]): List[A] = {
    def compressR(result: List[A], curList: List[A]): List[A] = curList match {
      case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
      case Nil       => result.reverse
    }
    compressR(Nil, list)
  }
  def compress2[A](ls: List[A]): List[A] =
    ls.foldRight(List[A]()) { (h, r) =>
      if (r.isEmpty || r.head != h) h :: r
      else r
    }

  /* Determine the greatest common divisor of two positive integer numbers. */
  def gcd(x: Int, y: Int): Int = if(y == 0) x else gcd(y, x % y)
  def gcdLoop(x: Int, y: Int): Int = {
    var a = x 
    var b = y 
    while(a != 0 ){
      val temp = a 
      a = b % a
      b = temp
    }
    b
  }
}