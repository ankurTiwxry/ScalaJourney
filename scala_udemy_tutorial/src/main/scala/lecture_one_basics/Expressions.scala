package lecture_one_basics

object Expressions extends App {
  var a_variable = 1 + 4;
  println(a_variable);

  // Instructions vs Expressions
  // Instruction: You tell what the computer should > DO (Imperative languages)
  // Expression: Has a value and or a type > VALUE

  // IF expression
  val a_condition = true;
  val a_conditioned_value = if(a_condition) 5 else 3; // we are only setting a value

  println(a_conditioned_value);

  // Loops are discouraged: Only execute side-effects
  // Very specific to imperative programming

  // EVERYTHING IN SCALA IS AN EXPRESSION

  val a_weird_value = (a_variable = 3)

  // Side effects : Remnants of imperative programming
  // println(), whiles, reassigning

  // CODE BLOCKS : Expressions
  val a_code_block = {
    val y = 2
    val z = y+1

    if(z>2) "hello" else "goodbye"
    // value of code-block is the value of the last expression
  }

}
