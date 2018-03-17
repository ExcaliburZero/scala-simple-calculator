package simplecalculator

object Main {
def main(args: Array[String]): Unit = {
  while (true) {
    // Prompt the user
    print("calculator> ")

    // Read in a line of input
    val input = scala.io.StdIn.readLine()

    // End if they enter ":q", also note that you don't need to
    // use ".equals"
    if (input == ":q") {
      return
    } else {
      val parsed = OurParsers.parse(OurParsers.expressionParser, input)

      parsed match {
        case OurParsers.Success(matched,_) =>
          val value = evaluate(matched)
          println(value)
        case OurParsers.Failure(msg,_) =>
          println("Failure: " + msg)
        case OurParsers.Error(msg,_) =>
          println("Error: " + msg)
      }
    }

  }
}


  def evaluate(expression: Expression): Int = {
    expression match {
      case Addition(ex1, ex2) => evaluate(ex1) + evaluate(ex2)
      case Subtraction(ex1, ex2) => evaluate(ex1) - evaluate(ex2)
      case Number(n) => n
    }
  }
}
