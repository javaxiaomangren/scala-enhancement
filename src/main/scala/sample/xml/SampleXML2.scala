package sample.xml

import scala.xml._

object SampleXML2 extends App{
  val xml = 
    <countries>
      <country isoCode="AU">Australia</country>
      <country isoCode="GB">Great Britain</country>
      <country isoCode="CN">China</country>
    </countries>
  def match1{
    xml match{
      case <countries>{cs @ _*}</countries> =>
        for(c <- cs)
          c match{
            case cNode @ <county>{name @ _*}</county> if((cNode \ "@isoCode").text == "CN") => print("I love " + name)
            case _ => Unit
          }
    }
  }
  def match2{
    val v = xml \\ "@isoCode"  filter(iso => (iso.text == "CN"))
   println(v)
  }
  def match3{
//    val scalasXML = xml.asScalas.rootElem
  }
//  match2
//  println( xml \\ "@isoCode" )
//  val a = List(1)
//  a.sum
}
