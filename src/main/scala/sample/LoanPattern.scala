package sample

import java.io.{PrintWriter, File}

object LoanPattern {
   def main(args: Array[String]){
     val f = new File("LoanPattern.txt")
     writeFile(f){
       _.println("Test for loan pattern ")
     }
   }

  def writeFile(file: File)(ops: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try{
      ops(writer)
    }finally {
      writer.close
    }
  }

}
