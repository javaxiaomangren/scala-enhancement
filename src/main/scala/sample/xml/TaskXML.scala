package sample.xml

import scala.xml._

object TaskXML extends App{
//  task1
//  task2
//  task3
  def task1 = {
    val str = "<a href=\"www.tuan800.com\">tuan800</a>"
    val t = XML.loadString(str)
    print(t getClass)
  }
  def task2 = {
    val div = 
      <div>
        <a href="www.tuan800.com1">tuan800_1</a>
        <a href="www.tuan800.com2">tuan800_2</a>
      </div>
    div match {
      case <div>{links @ _*}</div> => 
        for(link @ <a>{_*}</a> <- links)
          println(link)
    }
    
    div match {
      case <div>{links @ _*}</div> => 
        for(link <- links)
          println((link))
    }
//    println(XML.whiten(div,""))
  }
  def task3 {
    val url = <div>
      <a href="www.tuan800.com">800</a>
      <span class="bold">this is span1</span>
      <span class="span2">this is span 2</span>
      <div>
        <span class="bold">this is span3</span>
        <span class="span2222">this is span33</span>
      </div>
      <span class="bold">this is span4</span>
              </div>
    val urlLink = url \\ "span"
    println(urlLink)
    val newUrl = <a href={urlLink \"@href"}>{ url.text}</a>
//    println(newUrl)
 
//    val spans = url \ "span"
////    val bolds = spans \\ "@class"
//    println(spans)
    url match {
      case <div>{span1 @ _*}</div> => 
        for(sp  @ <span>{_*}</span> <- span1)
          println(sp.attribute("class"))
      case _ => print("ending")
    } 
  }
  

  val node = <a id="2">apple</a>
  (node  \\"a" \"@id").text match {
    case "2" => "It's an a: "+ (node \\"a").text
    case _ => "It's something else."
  }
  node match {
  case a @ <a>{contents}</a> if (a \ "@id").text == "2" => "It's an a: " + contents
  case _ => "It's something else."
}
//  val uls =
//    <ul>
//      <li clas="bold">1</li>
//      <li clas="bd">2</li>
//      <li clas="b">3</li>
//      <li clas="bold">4</li>
//    </ul>
// val a =  uls \ "li" filter(a => (a \ "@clas").text == "bold")
// println(a)
////  uls match { 
////  case <ul>{l @ <li>{theText}</li>}</ul> => 
////    println("An %s text: %s".format(l \ "@type", theText))
////}
  def task4 {
    val url = <div>
      <a href="www.tuan800.com">this11</a>
      <span class="bold1">this2</span>
      <span class="span2">this3</span>
      <div>
        <span class="bold3">this14</span>
        <span class="bold4">this5</span>
      </div>
      <span class="bold5">this6</span>
              </div>
    val t = url \\"*"
   println(t)
  }
  task4
  
  
}
