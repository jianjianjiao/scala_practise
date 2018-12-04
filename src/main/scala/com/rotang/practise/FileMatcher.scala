package com.rotang.practise

import java.io.File

/**
  * Chapter 9 Control Abstraction. Use functional programming to reduce code duplication.
  */
class FileMatcher {

  private def filesHere = listFileRecur(new File("."))

  private def listFileRecur(f : File) : Seq[File] = {
    val these = f.listFiles()
    these.filter(!_.isDirectory) ++ these.filter(_.isDirectory).flatMap(listFileRecur)
  }

  def filesMatch(query : String, matcher: (String, String) => Boolean) = {
    for(file <- filesHere if matcher(file.getName, query))
      yield file
  }
}

object FileMatcher {
  def run(): Unit ={
   val mkString = (files : Seq[File]) =>
     if(files.isEmpty)
       "no file found"
     else
       files.map(_.getAbsoluteFile).mkString("\n")

    val filesMatch = new FileMatcher

    val matchedFiles = filesMatch.filesMatch(".scala", _.endsWith(_))
    println ("files end with .scala")
    println(mkString(matchedFiles))

    val matchedFiles2 = filesMatch.filesMatch("Search", _.contains(_))
    println ("files contains 'Search'")
    println(mkString(matchedFiles2))
  }
}
