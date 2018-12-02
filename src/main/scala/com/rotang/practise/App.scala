package com.rotang.practise

/**
 * @author ${user.name}
 */
object App {

  def main(args : Array[String]) {
    val app = if(!args.isEmpty) args(0) else ""

    app match {
      case "MultiplicationTable" => MultiplicationTable.run
      case "Rational" => Rational.run
      case "Search" => Search.run
      case _ => println("huh?")
    }
  }
}
