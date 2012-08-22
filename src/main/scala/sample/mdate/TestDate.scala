package sample.mdate

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

object TestDate extends App{
    val cal = Calendar.getInstance
    val dateFormat = new SimpleDateFormat("yyyy年MM月dd日")
    cal.setTimeInMillis(1345084344350L)
    val date = dateFormat.format(cal.getTime)
    println(date)
}
