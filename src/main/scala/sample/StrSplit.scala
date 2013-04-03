package sample

object StrSplit extends App{
  val s = "Beijing,Shanghai,Guangzhou,Shenzheng,Hainan,Wuhan,Changsha,Shijiazhuang"
  val citys = s.split(",").toList
  
  println(isHot3("China_Wuhan_Dongchengqu", citys))
  
  def isHot(strId: String, cities: List[String]): Boolean = {
    var b = false
    cities.foreach{ c =>
      val tmp = strId.contains(c.toCharArray)
      if(tmp){
        b = tmp
      }
    }
    b
  }
  def isHot2(strId: String, cities: List[String]) = {
    val hot = cities.filter(e => strId.contains(e.toCharArray))
    println(hot)
    hot.size == 1
  }
   def isHot3(strId: String, cities: List[String]) =
    cities.find(c => strId.contains("_" + c)).nonEmpty
}
