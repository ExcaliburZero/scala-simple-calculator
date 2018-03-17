package simplecalculator

sealed trait Expression
case class Addition(first: Expression, second: Expression) extends Expression
case class Subtraction(first: Expression, second: Expression) extends Expression
case class Number(value: Int) extends Expression
