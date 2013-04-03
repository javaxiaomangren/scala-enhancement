package sample.list

class Point(val x: Int, val y: Int) {
  //1. 以错误的方式定义equals方法
  def equals(other: Point): Boolean =               //other should be Any, parameter error , not override but overload(get the static parameter type not runtime type)
    this.x == other.x && this.y == other.y
  
  // without override hashCode,
  //2. 修改equals但是没有同时修改hashCode方法
  override def equals(any: Any): Boolean = any match{     
    case that: Point => this.x == that.x && this.y == that.y
    case _ => false 
  }
  
//  def == (other: Point): Boolean // Don't do this
    
}

//3. 用可变字段定义equals
// you should use val ,or don't override equals and hashCode(use other method name )
class Point2(var x: Int, var y: Int) {

  override def equals(any: Any): Boolean = any match{     
    case that: Point2 => this.x == that.x && this.y == that.y
    case _ => false 
  }
  
  override def hashCode = 41 * (41 + x) + y
}

//4.未能按照等同方式定义equals方法

object Color extends Enumeration{
  val Red, Orange, Yellow, Green, Blue, Indigo, Violet = Value
}

class ColoredPoint(x: Int, y: Int, val color: Color.Value) 
  extends Point(x, y){ //equals 方法不对成
  
  override def equals(other: Any): Boolean = other match{
    case that: ColoredPoint => 
      (this.color == that.color) && super.equals(that)
    case _ => false
  }
  //test:
  //val p = new Point(1,2)
  //val cp = new ColoredPoint(1, 2, Color.Red)
  //p equals cp --> true
  //cp equals p --> false 
}
class ColoredPoint2(x: Int, y: Int, val color: Color.Value) 
  extends Point(x, y){ 
  
  override def equals(other: Any): Boolean = other match{
    case that: ColoredPoint => 
      this.color == that.color && super.equals(that)
    case that: Point => 
      that equals this
    case _ => false
  }
}


object Point extends App{
  val p1 = new Point(1, 2)
  val p2 = new Point(1, 2)
  val pa: Any = p2
  println(p1 equals p2)
  println(p1 equals pa)
  println(Color.Blue)
}
