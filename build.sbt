name := "simplecalculator"

version := "1.0"
scalaVersion := "2.12.1"

mainClass in Compile := Some("simplecalculator.Main")

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.0"
