package sample

class Rational(n: Int, d: Int) {
  //invoke Predef.require, ensure denominator is not zero
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g
  //A constructer with one parameter(the numerator)
  def this(n: Int) = this(n , 1)
  
  def +(that: Rational): Rational =
    new Rational(
      that.numer * denom + numer * that.denom,
      that.denom * denom
    )
  def +(i: Int): Rational = new Rational(i * denom + numer, denom)
  def -(that: Rational): Rational = 
    new Rational(
      numer * that.denom - that.numer * denom, 
      that.denom * denom
    )
  def -(i: Int): Rational = new Rational(numer - i * denom, denom)
  def *(that: Rational): Rational = 
    new Rational(numer * that.numer, denom * that.denom)
  def *(i: Int): Rational = new Rational(numer * i, denom)
  def / (that: Rational): Rational = 
    new Rational(numer * that.denom , denom * that.numer)
  def /(i: Int): Rational = new Rational(numer, denom * i)
  def lessThan(that: Rational): Boolean = this.numer * that.denom < that.numer * this.denom
  
  private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
  override def toString = if(denom == 1) numer+"" else (numer + "/" + denom) 
}
