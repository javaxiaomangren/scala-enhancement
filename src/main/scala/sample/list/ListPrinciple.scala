package sample.list



object ListPrinciple extends App{
   val ls = List(1, 2, 3, 4, 5)
   ls collect {case x if x % 2 == 0 => x}
   ls.combinations(3)
   val sb = ls.addString(new StringBuilder)
}
