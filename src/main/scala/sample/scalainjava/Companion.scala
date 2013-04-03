package sample.scalainjava

class Companion {
  def hello(){ println("hello (class)") }
}
object Companion{
  def hallo() { println("hello(object)") }
  def hello() { println("hello(object)") }
}