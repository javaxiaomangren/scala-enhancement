package sample.traitss

import scala.collection.mutable.ArrayBuffer

object TraitDemo extends App{
  val double  = new BasicIntQuery with Doubling
//  val double_filter = new BasicIntQuery with Doubling with Filtering
  double.put(10)
//  double_filter.put(-100)
  print(double.get)
//  print(double_filter.get)
  
}
abstract class IntQuery{
  def put(x: Int)
  def get(): Int 
}
class BasicIntQuery extends IntQuery{
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int){buf += x}
}
trait Doubling extends IntQuery{
  abstract override def put(x: Int) { super.put(x*2)}
}
trait Incoming extends IntQuery{
  abstract override def put(x: Int) {super.put(x+1)}
}
trait Filtering extends IntQuery{
  abstract override def put(x: Int){if(x >= 0) super.put(x)}
}
//trait Filtering extends IntQuery{
//  private val result = super.get
//  abstract override def get() = if(result > 0) result else super.get 
// }
