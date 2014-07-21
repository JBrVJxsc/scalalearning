package com.scala.exercises.impatient.chapter14

/**
 * Created by Who on 2014/7/21.
 */
sealed abstract class Amount

case class Dollar(value: Double) extends Amount

case class Currency(value: Double, unit: String) extends Amount