package com.rotang.practise

class Rational(n : Int, d: Int){
  require(d != 0)

  private val g = gcd (n, d)

  val numer = n / g
  val denom = d / g
  def this(n : Int) = this(n, 1)

  def add(that : Rational) : Rational =
    new Rational( numer * that.denom + denom * that.numer,
      denom * that.denom)

  private def gcd(a:Int, b: Int) : Int = {
    if(b == 0) a else gcd(b, a % b)
  }

  override def toString: String =  numer + "/" + denom
}

object  Rational {
  def run = {
    val oneThirds = new Rational(1,3)
    val half = new Rational(1,2)
    println(oneThirds.add(half))
  }
}
