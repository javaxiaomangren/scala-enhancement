package sample.traitss
class Animal
trait HasLegs
class Flog extends Animal with Philosophical with HasLegs{
  override def toString = "green"
  override def philosophize(){
    println("It ain't easy being" + toString + "!");
  }
}