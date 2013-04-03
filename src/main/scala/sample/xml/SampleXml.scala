package sample.xml

import scala.xml.Node
import scala.xml._

object SampleXml extends App{
  abstract class CCTherm{
    val description: String
    val yearMade: Int
    val dateObtained: String
    val bookPrice: Int
    val purchasePrice: Int
    val condition: Int
    override def toString = description
    def toXML =  {
      <cctherm>
        <description>{description}</description>
        <yearMade>{yearMade}</yearMade>
        <dateObtained><year><month><day>{dateObtained}</day></month></year></dateObtained>
        <bookPrice>{bookPrice}</bookPrice>
        <purchasePrice>{purchasePrice}</purchasePrice>
        <condition>{condition}</condition>
      </cctherm>
    }
  }
  def fromXML(node: Node): CCTherm = {
    new  CCTherm{
      val description = (node \ "description").text
      val yearMade = (node \ "yearMade").text.toInt
      val dateObtained = (node \ "dateObtained").text
      val bookPrice = (node \ "bookPrice").text.toInt
      val purchasePrice = (node \ "purchasePrice").text.toInt
      val condition = (node \ "condition").text.toInt
    } 
  }
  def proc(node: Node): String = node match{
    case <description>{description  @ _*}</description> => "It's a/an :" + description
    case <a>{content}</a>                     => "It's a/an " + content
    case _ => "it's Nothing !"
  }
  
  val term = new  CCTherm{
    val description = "hot dog #5"
    val yearMade = 2001
    val dateObtained = "March 14,2006"
    val bookPrice = 1000
    val purchasePrice = 150
    val condition = 9
  }
//  print(term.toXML)
//  print(term.toXML.text)
//  print(term.toXML.attribute("description"))
  val node = term.toXML
//  val cctherm = fromXML(node)
//  println(cctherm)
//  XML.saveFull("therm1.xml", node, "UTF-8", true, null)
//  println(fromXML(XML.loadFile("therm1.xml")))
 println(proc(<description><test>hhahhahhahah</test></description>))
 val desc = node \ "description"
 val date = node \\ "dateObtained"
 println(desc)
 println(date getClass)
}
