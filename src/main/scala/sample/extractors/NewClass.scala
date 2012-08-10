package sample.extractors

object NewClass extends App{
  val email =  Email("join","tuan800.com")
  val result = email match{
    case Email(user, domain) => email
    case _ => None
  }
  println(result)
    
  "YANGHUA@RD.TUAN800.COM" match{
    case Email(Twice(x @ UpperCase()), domain) => println("match" + x + "in domain" + domain)
    case _ => println("no match")
  }
}

object Email extends Function2[String, String, String]{
  override def apply(user: String, domain: String) = user + "@" + domain
  
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if(parts.length == 2)
      Some(parts(0), parts(1))
    else
      None
  }
}
//0/1 variable pattern
object Twice {
  def apply(s: String): String = s + s
  def unapply(s: String): Option[String] = {
    val length = s.length / 2
    val half = s.substring(0, length)
    if(half == s.substring(length)) Some(half) else None
  }
}

object UpperCase{
  def unapply(s: String): Boolean = s.toUpperCase == s
}

object Domain{
  def apply(parts: String *): String = parts.reverse.mkString(".")
  
  def unapplySeq(whole: String): Option[Seq[String]] = Some(whole.split("\\.").reverse)
}