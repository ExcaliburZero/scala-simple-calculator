package simplecalculator

import scala.util.parsing.combinator._

object OurParsers extends RegexParsers {
  val numberParser = "[0-9]+".r ^^ { str => Number(str.toInt) }

  val expressionParser = numberParser | additionParser | subtractionParser
  val additionParser: Parser[Expression] = "(" ~ expressionParser ~ "+" ~ expressionParser ~ ")" ^^ { case _ ~ ex1 ~ _ ~ ex2 ~ _ => Addition(ex1, ex2) }
  val subtractionParser: Parser[Expression] = "(" ~ expressionParser ~ "-" ~ expressionParser ~ ")" ^^ { case _ ~ ex1 ~ _ ~ ex2 ~ _ => Subtraction(ex1, ex2) }

}
