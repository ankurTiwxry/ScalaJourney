package lecture_one_basics

object Arguments extends App{

  def trFact(n: Int, acc: Int = 1): Int = {
    if(n<=1) acc
    else trFact(n-1, n*acc)
  }

  // Created an overload for the function by specifying a default value
  // but only with trailing parameters
  // unless you specify the value directly with a comma separated key-pair list
  // but this leads to a side effect as we can change the order of arguments
  val fact10 = trFact(10)
}
