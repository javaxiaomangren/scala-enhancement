/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.tools

import java.text.SimpleDateFormat

object Tools extends App{
  
  
  val t = timeMillisToDate(1345108107694L, "yyyy/MM/dd hh:mm:ss")
  println(t)
  def timeMillisToDate(millis: Long , format: String) = 
    new SimpleDateFormat(format).format(millis) 
  
}
