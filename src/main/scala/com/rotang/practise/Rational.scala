package com.rotang.practise

/**
  *
  * Add trait Ordered
  * @param n
  * @param d
  */
class Rational(n : Int, d: Int) extends Ordered[Rational]{
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

  override def compare(that: Rational): Int = {
    this.numer * that.denom - this.denom * that.numer
  }
}

object  Rational {
  def run = {
    val oneThirds = new Rational(1,3)
    val half = new Rational(1,2)
    println(oneThirds.add(half))
    println(s"1/3 > 1/2 ? ${oneThirds > half}")
    println(s"52/65 <= 50/66 ? ${new Rational(52, 65) <= new Rational(50,66)}")

    println(s"52/65 >= 520/650 ? ${new Rational(52, 65) >= new Rational(520,650)}")
}
}
