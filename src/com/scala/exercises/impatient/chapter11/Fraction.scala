package com.scala.exercises.impatient.chapter11

/**
 * Created by Who on 14-7-13.
 */
class Fraction(val num: Int,val den: Int) {
  def *(second: Fraction) = {
    Fraction(num * second.num, den * second.den)
  }
}

object Fraction {

  def apply(num: Int, den: Int) = {
    new Fraction(num, den)
  }

  def unapply(input: Fraction) = {
    if (input.den == 0) None else Some((input.num, input.den))
  }
}
