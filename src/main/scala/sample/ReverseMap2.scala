package sample


object ReverseMap2 extends App {
  
  val in = Map('a -> List("110000", "120000", "401300"), 'b -> List("110000", "120000", "201300"))
  val out = Map("110000" -> List('a, 'b), "120000" -> List('a, 'b), "401300" -> List('a), "201300" -> List('b))
  
  def reverseAndAggregation(map: (Symbol, Seq[String])*) = {
    map.foldLeft(scala.collection.mutable.Map[String, List[Symbol]]()) {
      case (resultMap, (k, v)) =>
        v foreach { v1 => 
          val e = resultMap.getOrElseUpdate(v1, List.empty)
          resultMap.put(v1, k :: e)
        }
        resultMap
    }
  }
  
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
    
  def inverse[K, V](map: (K, Seq[V])*) = {
    map.flatMap(kv => kv._2.map((_, kv._1))).toMap
  }

//  val map = scala.collection.mutable.Map[Symbol, List[String]]()
//  val map2 = scala.collection.mutable.Map[String, List[Symbol]]()
//  
//  def fe[K, V](map: Map[K, List[V]]): Map[V, List[K]] ={
//    Map[V, List[K]]().empty ++ map.foldLeft(scala.collection.mutable.Map[V, List[K]]()){
//      case (result, (k, v)) =>
//        v.foreach{
//          v1 => 
//          val e = result.getOrElseUpdate(v1, Nil)
//          result.put(v1, (k :: e).reverse)
//        }
//        result
//    }
//  }

  def t[K, V](map: Map[K, List[V]]) = {
    map.foldLeft(scala.collection.mutable.Map[V, List[K]]()) {
      case (resultMap, (k, v)) =>
        v.foreach{
          v1 =>
          val elem = resultMap.getOrElseUpdate(v1, Nil)
          resultMap.put(v1, k :: elem)
        }
        resultMap
    }
  }

}
