package sample.xml

import scala.xml._
import java.net.URL

object CgvXml extends App {
//  val xml = XML.load(new URL("http://www.cgvxingx-olympic.com/schedule.aspx"))
//  val xml2  =
//  val tbody  = xml \\ "*[@id='cont']" \ "table" \ "tbody"
//  val date = tbody \ "tr[1]"
val str = "booking.aspx?type=movie&date=白雪公主之魔镜魔镜（数字)"
  val xmls = <a class="title" href={str} >白雪公主之魔镜魔镜（数字）</a>
  val t = (xmls \ "@href" text).trim
  println(t)
//booking.aspx?type=movie&data=白雪公主之魔镜魔镜（数字)
}
