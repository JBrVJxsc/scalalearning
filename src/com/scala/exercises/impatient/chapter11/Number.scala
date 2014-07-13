package com.scala.exercises.impatient.chapter11

/**
 * Created by Who on 14-7-13.
 */
object Number {
  def unapply(input: String): Option[Int] = {
    try {
      Some(Integer.parseInt(input))
    } catch {
      case ex: NumberFormatException => None
    }
  }
}
