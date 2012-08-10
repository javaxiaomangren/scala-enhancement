package sample.mdate

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

object TestDate extends App{
    val today = new Date()
    val cal = Calendar.getInstance
    val dateFormat = new SimpleDateFormat("yyyy年MM月dd日")
    cal.setTime(today)
  println(today.getTime)
  println(cal.getTimeInMillis)
    println(dateFormat.format(today))
    
}
