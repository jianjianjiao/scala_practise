package com.rotang.practise

/**
  * Chapter 7, looping using imperative or functional way.
  */
class Search {

  def search(args : Array[String]) : Int = {
    var i = 0
    var foundIt = false

    while( i < args.length && !foundIt){
      if( args(i).endsWith(".scala"))
        foundIt = true
      i = i + 1
    }

    if(foundIt) i - 1 else -1
  }

  def searchFunctional(args : Array[String]) : Int = {
    searchFrom(args, 0)
  }

  private def searchFrom(args : Array[String], i : Int) : Int = {
    if( i >= args.length ) -1
    else if(args(i).endsWith(".scala")) i
    else searchFrom(args, i + 1)
  }
}

object Search{
  def run: Unit = {
    val args = Array("scala", "-cp", ".", "abc.scala")
    println (s"Search using loop, result, ${new Search().search(args)}")
    println (s"Search using functional way, result, ${new Search().searchFunctional(args)}")
  }
}
