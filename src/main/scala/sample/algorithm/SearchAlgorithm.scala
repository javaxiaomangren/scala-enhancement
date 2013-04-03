package sample.algorithm

import scala.annotation.tailrec

object SearchAlgorithm {

  def search(target:Int, l:List[Int]) = {
    @tailrec 
    def recursion(low:Int, high:Int):Option[Int] = (low+high)/2 match{
      case _ if high < low => None 
      case mid if l(mid) > target => recursion(low, mid-1)      
      case mid if l(mid) < target => recursion(mid+1, high)
      case mid => Some(mid)
    } 
    recursion(0,l.size - 1)
  }

  def search2(target:Int, l:List[Int]) = {
    def recursion(mid:Int, list:List[Int]):Option[Int]=  list match {
      case tar::Nil if tar == target => Some(tar)
      case tar::Nil => None 
      case ls => {
          val(lows,highs) = ls.splitAt(mid) 
          if (ls(mid)>target) 
            recursion((lows.size)/2, lows)
          else 
            recursion((highs.size)/2, highs)
         }
    }
    recursion((l.size)/2, l);
  }
  
}
