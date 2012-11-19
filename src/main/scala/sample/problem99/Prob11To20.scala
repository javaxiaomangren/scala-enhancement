package sample.problem99

object Prob11To20 extends App{

  
  /*
   *  P11  Modified run-length encoding
   *   scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   *   res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
   */
  
  def encodeModified[A](list: List[A]): List[Any] = {
    Prob01To10.encodingPacked(list).map{ e => 
      if(e._1 == 1) e._2 else e
    }
  }
//  println(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  
  /*
   * P12  Decode a run-length encoded list.
   * scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
   * res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
   */
  def decodeList[A](list: List[(Int, A)]): List[A] = {
    list.flatMap { e =>
      List.fill(e._1)(e._2)
    }.toList
  }
//  println(decodeList(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
  /*
   * P13 (**) Run-length encoding of a list (direct solution).
   * scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
   */
  def encodingDerict[A](list: List[A]):List[(Int, A)] = {
    if(list.isEmpty) Nil
    else{
      val (packed, next) = list.span{ _ == list.head }
      (packed.length, packed.head) :: encodingDerict(next)
    }
  }
//  println(encodingDerict(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  /*
   * P14 Duplicate the elements of a list.
   * duplicate(List('a, 'b, 'c, 'c, 'd))
   *  List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
   */
  
  def duplicate[A](list:List[A]):List[A] = list.flatMap{ e => List(e, e)}.toList
  def duplicate2[A](list:List[A]):List[A] = list.flatMap{ e => List.fill(2)(e)}.toList
  def duplicate3[A](list:List[A]):List[A] = list.foldLeft(List[A]()){(r, e) => e::e::r }.reverse

//  println(duplicate(List('a, 'b, 'c, 'c, 'd)))
//  println(duplicate2(List('a, 'b, 'c, 'c, 'd)))
//  println(duplicate3(List('a, 'b, 'c, 'c, 'd)))
  
  /*
   * P15 Duplicate the elements of a list a given number of times.
   * scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
   * res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
   */
  def duplicateN[A](n: Int, list:List[A]): List[A] = list.flatMap{List.fill(n)(_)}.toList

//  println(duplicateN(3, List('a, 'b, 'c, 'c, 'd)))
  /*
   *  P16 Drop every Nth element from a list.
   *  scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   *  res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
   */
  def dropEveryNth[A](n: Int, ls: List[A]) = ls.zipWithIndex filter {e => (e._2+1) % n != 0 } map{_._1}
//  println(dropEveryNth(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  
  /*
   * P17 (*) Split a list into two parts.
   The length of the first part is given. Use a Tuple for your result. 
   scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   */
  
  def split1[A](n: Int, ls: List[A]): (List[A], List[A]) =  ls.splitAt(n)
  def split2[A](n: Int, ls: List[A]): (List[A], List[A]) =  (ls.take(n), ls.drop(n))
  def split3[A](n: Int, ls: List[A]): (List[A], List[A]) =  (n, ls) match{
    case (_, Nil)     => (Nil, Nil)
    case (0, list)    =>(Nil, list)
    case (n, h::tail) => {
        val (pre, post) = split3(n-1, tail)
        (h::pre, post)
      }
  }
  /*
   * P18 (**) Extract a slice from a list.
   * scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   res0: List[Symbol] = List('d, 'e, 'f, 'g)
   */
  def slice[A](i: Int, k: Int, ls: List[A]) = ls.slice(i, k)
  
  def sliceRecursive[A](i: Int, k: Int, ls: List[A]): List[A] =  (i, k, ls) match {
    case (_, _, Nil)                 => Nil
    case (_, e, _)         if e <= 0 => Nil
    case (s, e, h :: tail) if s <= 0 => h :: sliceRecursive(0, e - 1, tail)
    case (s, e, h :: tail)           => sliceRecursive(s - 1, e - 1, tail)
  }
  
  def sliceTailRecursive[A](start: Int, end: Int, ls: List[A]): List[A] = {
    def sliceR(count: Int, curList: List[A], result: List[A]): List[A] = {
      (count, curList) match{
        case (_, Nil)                      => Nil
        case (c, h :: tail)   if(end <= c) => result.reverse
        case (c, h :: tail) if(start <= c) => sliceR(c+1, tail, h::result)
        case (c, _ :: tail)                => sliceR(c+1, tail, result)
      }
    }
    sliceR(0, ls, Nil)
  }
  
  def slice2[A](i: Int, k: Int, ls: List[A]) = ls.drop(i).take(k-(i max 0))
//  println(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
//  println(slice2(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
//  println(sliceRecursive(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
//  println(sliceTailRecursive(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

  /*
   * P19 (**) Rotate a list N places to the left.
   scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
   // scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   //res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
   */

  def rotate[A](n: Int, ls: List[A]): List[A] = {
    val point = if(ls.isEmpty) 0 else n % ls.length
    if(point < 0) rotate(point + ls.length, ls)
    else ls.drop(point) ::: ls.take(point)
  }
  
//  println(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  
  /*
   *P20 (*) Remove the Kth element from a list. 
   scala> removeAt(1, List('a, 'b, 'c, 'd))
   res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
   */
  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = {
    val l = ls.zipWithIndex filterNot {e => e._2 == n } map{_._1}
    (l, ls.apply(n))
  }
  
  def removeAt2[A](n: Int, ls: List[A]): (List[A], A) = ls.splitAt(n) match {
    case (Nil, _) if n < 0 => throw new NoSuchElementException
    case (pre, e :: post)  => (pre ::: post, e)
    case (pre, Nil)        => throw new NoSuchElementException
  }

  // Alternate, with fewer builtins.
  def removeAt3[A](n: Int, ls: List[A]): (List[A], A) =
    if (n < 0) throw new NoSuchElementException
    else (n, ls) match {
      case (_, Nil) => throw new NoSuchElementException
      case (0, h :: tail) => (tail, h)
      case (_, h :: tail) => {
        val (t, e) = removeAt(n - 1, ls.tail)
        (ls.head :: t, e)
      }
    }
  println(removeAt(1, List('a, 'b, 'c, 'd)))
  
}
