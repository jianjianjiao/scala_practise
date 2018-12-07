package com.rotang.practise

trait Ordered[T] {
  def compare(that : T) : Int

  def > (that: T) =  this.compare(that) > 0

  def >= (that: T) = this.compare(that) >= 0

  def < (that: T) = this.compare(that) < 0

  def <=(that: T) = this.compare(that) <=0
}
