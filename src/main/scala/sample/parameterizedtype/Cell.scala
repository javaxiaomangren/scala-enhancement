///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package sample.parameterizedtype
//
//class Cell[+T](init: T) {
//  private[this] var current = init
//  def get = current
//  def set(x: T) = { current = x}
//}
//object Test extends App{
//  val c1 = new Cell[String]("abc")
//  val c2: Cell[Any] = c1
//}