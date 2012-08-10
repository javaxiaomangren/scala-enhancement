package sample.regex

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

object DateAndRegex extends App{
  
    testURLRegAndDate
  
  def testRegDate(){
    val  str ="http://www.cgvxingx-olympic.com/schedule.aspx?date=2012年06月15日"
    val dateRegex = """(?<=[\?&]date=)\d{4}[\u4e00-\u9fa5]\d{1,2}[\u4e00-\u9fa5]\d{1,2}[\u4e00-\u9fa5]""".r
    val dateFormat = new SimpleDateFormat("yyyy年MM月dd日")
    val d = dateRegex.findFirstIn(str).get
    val cal = Calendar.getInstance
    cal.setTime(dateFormat.parse(d))
    cal.add(Calendar.DAY_OF_MONTH, 1)
    val nextD = dateFormat.format(cal.getTime)
    val url = dateRegex.replaceAllIn(str, nextD)
    println(url)
    val dateFormat2 = new SimpleDateFormat("yyyy-MM-dd")
    val dn = dateFormat2.format("2012年06月15日")
    println(dn)
  }
  
//    val date = regex.findFirstIn(str).get
//    println(date)
//    val today = new SimpleDateFormat("yyyy年MM月dd日")
//    val cal = Calendar.getInstance
//    val d = today.format(cal.getTime)
//    print(d)
//    for(i <- 1 to 10){
//      println(i%2)
//    }
  

  
  def testDate2(){
    val d = "2012年06月30日"
    val dateFormat = new SimpleDateFormat("yyyy年MM月dd日")
    val cal = Calendar.getInstance
    cal.setTime(dateFormat.parse(d))
    cal.add(Calendar.DAY_OF_MONTH, 1)
    val nextD = dateFormat.format(cal.getTime)
    println(nextD)
    val dateFormat2 =  new SimpleDateFormat("yyyy_MM_dd")
    val   today = dateFormat2.format(new Date())
    val todays = dateFormat2.parse(dateFormat2.format(new Date))
    println(todays)
  }
  
//[\u4e00-\u9fa5] //匹配一个中文字符
  def testURLRegAndDate(){
    val ul = "http://www.wandafilm.com/trade/time.do?m=init&cinema_id=311&day=2012_06_19&rond=0.8289721375331283"
    val reg =  """(?<=[\?&]day=)\d{4}[_]\d{1,2}[_]\d{1,2}[_]""".r
    println(reg.findFirstIn(ul))
    val cinemaId="222"
    val movieId="2001_10"
    val date="0.20121"
    val url = String.format("http://www.wandafilm.com/trade/time.do?m=init&cinema_id=%s&day=%s&rond=%s", cinemaId, movieId, date)
    println(url)
    val format1 = new SimpleDateFormat("yyyy_MM_dd")
    val format2 = new SimpleDateFormat("yyyy-MM-dd")
    format1.parse("2012_06_17")
    val dd  = format2.format(format1.parse("2012_06_17"))
    println(dd)
  }
  
}