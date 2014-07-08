package com.scala.exercises.impatient.chapter5

/**
 * Created by Who on 2014/7/8.
 */
class Counter {
  private[this] var value = 0

  def increment() {
    value += 1
  }

  def current() = value

  def isLess(other: Counter) = {
    // Because the member value is tagged private[this], so it will be only accessible for the same object.
//    value < other.value
  }
}
