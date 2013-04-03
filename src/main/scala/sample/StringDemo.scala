package sample

object StringDemo extends App{
  val str = "site_id,name,age,discription"
  if(str.contains(",")){
    val cond = str.split(",").toList
    val where = cond.foldLeft(new StringBuffer()){
      case(result ,b) =>
        result.append(String.format(" %s=1 and ", b))
    }.toString
  
    println(where)
  }
}
