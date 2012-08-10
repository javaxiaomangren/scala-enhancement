package sample
 
import java.util.Calendar
import java.util.Date
import java.util.Timer
import java.util.TimerTask

object Test extends App{
//  def getOrElseUpdate[V](region: String, key: Any, default: => V) = {
//    val cached = get(region, key)
//    cached match {
//      case Some(cached) =>
//        cached
//      case None =>
//        put(region, key, (System.currentTimeMillis, default))
//        default
//    }
//  }
//  put("beijing","123",(System.currentTimeMillis, "default"))
//  def put(region: String, key: Any, value: Any) = {
//     val v = value 
//     println(key , value)
//  }
////  
//  val cal = Calendar.getInstance
//  cal.set(Calendar.HOUR_OF_DAY, 0)
//  cal.set(Calendar.MINUTE, 0)
//  cal.set(Calendar.SECOND, 1)
//  cal.add(Calendar.DAY_OF_MONTH, 1)
//  println(24*60*60*1000)
//  println(cal.getTime)
//  val delay = cal.getTimeInMillis - new Date().getTime
//  println(delay)
//  val timer = new Timer
//  val timerTask = new TimerTask{
//    def run(){
//      println(System.currentTimeMillis)
//    }
//  }
//  timer.schedule(timerTask,delay ,24*60*60*1000)
  
  (200L,None) match{
    case (i:Long, v) => println(i,v)
    case _ => 
  }
  
  println(Option.apply(None).get)
  
}