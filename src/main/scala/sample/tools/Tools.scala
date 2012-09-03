/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.tools

import java.text.SimpleDateFormat

object Tools extends App{


  val t = timeMillisToDate(1346428800000L, "yyyy/MM/dd hh:mm:ss")
  val t2 = timeMillisToDate(1346344602852L, "yyyy/MM/dd hh:mm:ss")
  val t3 = timeMillisToDate(1346343859430L, "yyyy/MM/dd hh:mm:ss")
  val t4 = timeMillisToDate(1346304918784L, "yyyy/MM/dd hh:mm:ss")
  val t5 = timeMillisToDate(1346391318784L, "yyyy/MM/dd hh:mm:ss")
  val t6 = timeMillisToDate(1346344602852L, "yyyy/MM/dd hh:mm:ss")
//  val t2 = timeMillisToDate(1345779222706L-10000000L, "yyyy/MM/dd hh:mm:ss")
  println(t)
  println(t2)
  println(t3)
  println(t4)
  println(t5)
  def timeMillisToDate(millis: Long , format: String) = {
    val mat =  new SimpleDateFormat(format) 
//    println(mat.parse("2012/08/24 17:33:42").getTime)
//     println(mat.parse("2012/08/24 02:33:42").getTime)
//     println(mat.parse("2012/08/24 03:33:42").getTime)
//     println(mat.parse("2012/08/24 04:33:42").getTime)
//     println(mat.parse("2012/08/24 05:33:42").getTime
//     )
    new SimpleDateFormat(format).format(millis) 
  }
}
