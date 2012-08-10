package sample.pm

sealed abstract class Expr 
case class Var(name: String) extends Expr 
case class Number(num: Double) extends Expr
case class UnOp(operator: String , arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr



object PatternMatch {
  def main(args: Array[String]) {
     match1(BinOp("+", Var("yanggha"), Var("hua")))
     match2(UnOp("abc", UnOp("abc",Var("name"))))
     match3(BinOp("+",Number(21),Number(21)))
  }
  def simplifyTop(expr: Expr): Expr = expr match{
    case UnOp("-", UnOp("-", e)) => e // double -
    case BinOp("+", e, Number(0)) => e //加0
    case BinOp("*", e, Number(1)) => e //乘以1
    case _ => expr
  }
  //样本类的作用
   def caseClass{
     val v = Var("name")  //1. 自动添加与类名一致的工厂方法
     println(v.name)      //2. 样本类的参数列表中的所有参数隐式获得val前缀
     println(v.hashCode)  //3. 自动添加了hashCode , toString, equals 方法的自然实现
     println(v.toString)  //4. 最大的好处式能够支持模式匹配
                          //5. 支持序列化 
     
   }
  //通配模式
  def match1(expr: Expr) = expr match{
    case BinOp(op, left, right) => println(expr + "is a binary operation")
//    case BinOp(_, _ , _) =>  println("is a binary operation")
    case _ => println("It's nothing else")
  }
  //变量绑定
  def match2(expr: Expr) = expr match{
    case UnOp("abc", e @ UnOp("abc", _ ) ) => println(e)
    case _ => 
  }
  //构造器模式,深度匹配
  def constructorMatch (expr: Expr) = expr match{
    case BinOp("+", e, Number(0)) => println("a deep match")
    case _ => 
  }
  //序列模式
  def listMatch(expr: Expr) = expr match{
    case List(0, _, _) => println("found it ") //检查开始于0的三元列表
    case List(1, _*) => println("found it ")  //开始于1
    case _ =>
  }
  //元组模式， tuple match
    def tupleMatch(expr: Any) = expr match{
      case (a, b, c) => println("matched" + a + b + c )
      case _ =>
    }
   //类型模式
   def typeMatch(x: Any) = x match{
     case s: String => s.length
     case m: Map[String, String] => true  //类型擦除
     case l: List[_] => l.size
     case _ =>
   }
 
  //模式守卫
  def match3(expr: Expr) = expr match{
    case BinOp("+", x, y)if x == y =>
      println(BinOp("*", x, x))
    case _ =>
  }
  //封闭类
  def discribe(e: Expr): String = (e: @unchecked) match{
    case Number(_) => " a Number"
    case Var(_) => "a var "
  }
}