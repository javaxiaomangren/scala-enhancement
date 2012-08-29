/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.tools

import java.text.SimpleDateFormat

object Tools extends App{
  
  
  val t = timeMillisToDate(1345694074723L, "yyyy/MM/dd hh:mm:ss")
//  val t2 = timeMillisToDate(1345779222706L-10000000L, "yyyy/MM/dd hh:mm:ss")
//  println(t)
//  println(t2)
  def timeMillisToDate(millis: Long , format: String) = {
    val mat =  new SimpleDateFormat(format) 
    println(mat.parse("2012/08/24 17:33:42").getTime)
     println(mat.parse("2012/08/24 02:33:42").getTime)
     println(mat.parse("2012/08/24 03:33:42").getTime)
     println(mat.parse("2012/08/24 04:33:42").getTime)
     println(mat.parse("2012/08/24 05:33:42").getTime
     )
    new SimpleDateFormat(format).format(millis) 
  }
}
