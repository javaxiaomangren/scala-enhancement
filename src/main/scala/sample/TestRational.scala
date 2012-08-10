package sample

object TestRational {
  def main(args: Array[String]){
    val ra = new Rational(1,2)
    val ra1 = new Rational(2,3)
    println(ra1 / ra)
    println(ra * 2)
  }
}
