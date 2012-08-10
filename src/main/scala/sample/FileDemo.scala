package sample

import scala.io.Source

object FileDemo  {
  def main(args: Array[String]){
    val it = grep(".*for.*").iterator
    while(it.hasNext){
      println(it.next)
    }
  }
  def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines.toList
  def grep(pattern: String) = {
    val fileHere = (new java.io.File("src\\main\\scala\\sample")).listFiles
    for{
      f <- fileHere
      if f.getName.endsWith(".scala")
//      line <- fileLines(file)
//      if line.trim.matches("pattern")
    }yield f.getName
  }
  def widthOfLength(s: String): Int = s.length.toString.length
  def printFile(args: String){
    if(!args.isEmpty){
      val lines = Source.fromFile(args).getLines.toList
      val longestLine = lines.reduceLeft(
        (a, b) => if(a.length > b.length) a else b
      )
      val maxWidth = widthOfLength(longestLine)
      for(line <- lines){
        val numSpaces = maxWidth - widthOfLength(line)
        val padding = " " * numSpaces
        println(padding + line.length + " | " + line)
      }
    } else
      Console.err.print("Please Enter File Name ")
  }
}