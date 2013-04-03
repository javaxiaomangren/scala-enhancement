package sample

import scala.collection.JavaConversions._

object ReverseMap extends App {
  
  val in = Map('a -> List("110000", "120000", "401300"), 'b -> List("110000", "120000", "201300"), 'c -> List("110000", "120000", "501300"))
  val out = Map("110000" -> List('a, 'b, 'c), "120000" -> List('a, 'b, 'c), "401300" -> List('a), "201300" -> List('b) , "501300" -> List('c))
  val temp = new java.util.ArrayList[(String, List[Symbol])]
  

  def g[K, V](map: (K, Seq[V])*) = {
    map.foldLeft(scala.collection.mutable.Map[V, List[K]]()) {
      case (resultMap, (k, v)) =>
        v foreach { v1 => 
          val e = resultMap.getOrElseUpdate(v1, List.empty)
          resultMap.put(v1, k :: e)
        }
        resultMap
    }
  }
  
  def f(map: (Symbol, Seq[String])*) = {
    val ls = map.flatMap(kv => kv._2.map((_, List(kv._1)))).sortBy(_._1).toList
    val aggregated = dif(ls) 
    val group = temp.toList ::: aggregated
    dif2(group.sortBy(_._1)).toMap
  }
 
  def dif(ls: List[(String, List[Symbol])]): List[(String, List[Symbol])] = ls match {
    case Nil       => Nil
    case h :: tail => h :: dif(tail.dropWhile(count(_, h)))
  }
  
  def dif2(ls: List[(String, List[Symbol])]): List[(String, List[Symbol])] = ls match {
    case Nil       => Nil
    case h :: tail => h :: dif2(tail.dropWhile(_._1 == h._1))
  }
  
  def count(x: (String, List[Symbol]), y:(String, List[Symbol])):Boolean ={
    val b = x._1 == y._1
    if(b)
      temp.add((y._1, y._2 ::: x._2))
    b
  }
  
//  val result = f(in.toList:_*)
  val result = g(in.toList:_*)
  println(result)
  
}
