package sample.regex

object RegexSample extends App{
  
  //1.  ^     the beginning of a line
  //2.  $     the end of a line
  //3.  \b    a word boundary(边界)
  //4.  \B    a non-word boundary
  //5.  \A    The biginning of the input
  //6.  \G    The end of the previous match
  //7.  \Z    The end of the input but for the final terminator, if any
  //8.  \z    The end of the input
  //9.  [abc] a,b or c 
  //10, [^abc] Any charactor except a,b ,or c 
  //11. [a-zA-Z] a through z or A through Z , inclusive
  //12  [a-d[m-p]] 
  
  val reg1 = """ab?""".r  //'a',可能跟着'b'
    println(reg1, reg1.findFirstIn("jvxiadomengadasdfsf").get)
    
  val num = """\d+""".r  // 一个或者多个数字
    println(num, num.findFirstIn("dsf21312fdjk9999").get)
  
  val reg2 = """[a-dA-D]\w*""".r //a-d,A-D, 后缀为0或者n歌单词字符(数字,字母, 下划线)
    println(reg2, reg2.findFirstIn("DBad_fs&asdf oiasjdfo*(&^").get)
  
  val reg3 = """(-)?(\d+)(\.\d*)""".r  // 可选负号,跟一个或者多个数字,可选的点和那个数字
    val reg3(sign, integerpart, decimalpart) = reg3.findFirstIn("from -90.2323 to 10.00").get
    println(reg3+" ==> match: sign,integerpart, decimalpart ->", sign,integerpart, decimalpart)
    
  val isDigit = """^[0-9]*$""".r
//  println("验证是否数字:" , isDigit.)
  

}
