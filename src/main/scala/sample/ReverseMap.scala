package sample

import scala.collection.JavaConversions._

class ReverseMap extends App {
  
  val in = Map('a -> List("110000", "120000", "401300"), 'b -> List("110000", "120000", "201300"))
  val out = Map("110000" -> List('a, 'b), "120000" -> List('a, 'b), "401300" -> List('a), "201300" -> List('b))
  val temp = new java.util.ArrayList[(String, List[Symbol])]
 
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
  
  val result = f(in.toList:_*)
  println(result)
  println(result == out)
  
}
