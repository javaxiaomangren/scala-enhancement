/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.xml

object IteratorMapInXml extends App{
  val mp = Map("a"-> 21, "b" -> 22)
  val xml = <table>
    <tr></tr>
            </table>
  
  def ms(map: Map[String, Int]) ={
    <table>
      <tr>
        <td>字段名</td>
        <td>变化量</td>
        <td>变化率</td>
        <td>时间</td>
      </tr>
      {
        map.flatMap{
          kv => 
           <tr>
            <td>aaaa</td>
            <td>{kv._2}</td>
            <td>{50/200}</td>
            <td>{kv._1}</td>
          </tr>
        }
      }
    </table>
  }
  println(ms(mp))
}
