
package sample.file
import scalax.file._
import java.io._
import scalax.io.JavaConverters._
import scalax.file.ImplicitConversions._
import scopt.mutable._
object GnuPlot extends App{
  val gnuplot = new ProcessBuilder("gnuplot").start
  val writer = new PrintWriter(new OutputStreamWriter(gnuplot.getOutputStream, "utf8"))
  try {
    writer.println(scriptTemplate)
  } finally {
    writer.close
  }
  gnuplot.waitFor
  lazy val scriptTemplate = """
 data='~/NetBeansProjects/monitor/src/main/script/data'
start='2012-10-01'
end='2012-10-13'
name='statistics'
set terminal svg enhanced solid size 1200 400
set output '~/NetBeansProjects/monitor/src/main/script/statistic.svg'
set xdata time  
set timefmt "%Y-%m-%d"
set format x "%d/%m"
set xlabel 'Statistics time (Day)'
set ylabel name
plot [start:end] data using 1:2 with linespoints 

  """
}
