package sample

object Syntax extends App{
  val t = isIntMap(Map("adfas" -> "asdfjodasf")) 
  println(t) //true
  println(isArray(Array("abc")))
//  divide(2,0)
  def divide(x: Int, y: Int) = {
    if(y != 0) x/y
    else error("error y can not be 0")
  }
  //类型擦除
  def isIntMap(x: Any) = x match{
    case m: Map[Int, Int] => true
    case _ => false
  }
  //类型擦除,数组例外
  def isArray(a: Any) = a match{
    case a: Array[String] => true
    case _ => false 
  }
  var list:List[Nothing] =  List()
  
}
